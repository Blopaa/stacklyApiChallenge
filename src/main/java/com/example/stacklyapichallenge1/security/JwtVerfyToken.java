package com.example.stacklyapichallenge1.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtVerfyToken {
    public String verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("superSecret");
            JWTVerifier verifier = JWT.require(algorithm).withClaimPresence("id").build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asString();
        }catch (JWTVerificationException e){
            return null;
        }
    }
}
