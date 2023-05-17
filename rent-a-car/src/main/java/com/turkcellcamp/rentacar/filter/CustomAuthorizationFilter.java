package com.turkcellcamp.rentacar.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turkcellcamp.rentacar.business.concretes.CustomUserDetailsManager;
import com.turkcellcamp.rentacar.common.constants.Security;
import com.turkcellcamp.rentacar.utils.JwtHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    private final CustomUserDetailsManager userDetailsManager;

    public CustomAuthorizationFilter(CustomUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if(request.getServletPath().equals("/api/user/login")){
            filterChain.doFilter(request,response);
        }else{
            String authorizationHeader = request.getHeader(Security.SECURITY_HEADER);

            if(authorizationHeader != null && authorizationHeader.startsWith(Security.SECURITY_WITH_START_TOKEN)){
               try {
                   String token = authorizationHeader.substring(Security.SECURITY_WITH_START_TOKEN.length());
                   DecodedJWT decodedJWT = JwtHelper.decodedJWT(token);
                   String username = decodedJWT.getSubject();
                   UserDetails userDetails = userDetailsManager.loadUserByUsername(username);

                   UsernamePasswordAuthenticationToken authenticationToken =
                           new UsernamePasswordAuthenticationToken(userDetails.getUsername(),null,userDetails.getAuthorities());

                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                   filterChain.doFilter(request,response);
               }catch (JWTVerificationException e){
                   response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                   response.setStatus(401);

                   Map<String,String> responseErrorData = new HashMap<>();
                   responseErrorData.put("message",e.getMessage());
                   responseErrorData.put("timestamp", LocalDateTime.now().toString());

                   new ObjectMapper().writeValue(response.getOutputStream(),responseErrorData);
               }

            }else{
                filterChain.doFilter(request, response);
            }
        }
    }
}
