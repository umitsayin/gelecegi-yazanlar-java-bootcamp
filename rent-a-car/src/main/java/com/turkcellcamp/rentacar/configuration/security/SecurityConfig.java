package com.turkcellcamp.rentacar.configuration.security;

import com.turkcellcamp.rentacar.business.concretes.CustomUserDetailsManager;
import com.turkcellcamp.rentacar.filter.CustomAuthenticationFilter;
import com.turkcellcamp.rentacar.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationConfiguration configuration;
    private final CustomUserDetailsManager userDetailsManager;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter authenticationFilter
                = new CustomAuthenticationFilter(authenticationManager(configuration));
        authenticationFilter.setFilterProcessesUrl("/api/user/login");

        return http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.POST,"/api/users").permitAll();
                    auth.requestMatchers("/api/user/login").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/api/cars/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/api/brands/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET,"/api/models/**").permitAll();
                    auth.requestMatchers(HttpMethod.DELETE, "/api/cars/**").hasAuthority("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(authenticationFilter)
                .addFilterBefore(new CustomAuthorizationFilter(userDetailsManager), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
