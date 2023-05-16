package com.turkcellcamp.rentacar.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.turkcellcamp.rentacar.common.constants.Security;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class JwtHelper {
    public String createJwtToken(String username){
        final Algorithm algoritm = Algorithm.HMAC256(Security.SECRET_KEY);

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + Security.EXPIRED_DAY))
                .sign(algoritm);
    }

    public DecodedJWT decodedJWT(String token) throws JWTVerificationException{
        final Algorithm algoritm = Algorithm.HMAC256(Security.SECRET_KEY);
        final JWTVerifier verifier = JWT.require(algoritm).build();

        return verifier.verify(token);
    }
}
