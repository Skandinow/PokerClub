package com.svigel.pokerclub.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.svigel.pokerclub.model.PokerUser;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    //TODO убрать секрет в application.properties
    private static final String SECRET = "38c86b553adefeb3e579e39789e38664aef9176e";
    private static final Algorithm algorithm = Algorithm.HMAC256(SECRET);
    private static final JWTVerifier verifier = JWT.require(algorithm).build();
    private final PokerUserService pokerUserService;

    public JWTService(PokerUserService pokerUserService) {
        this.pokerUserService = pokerUserService;
    }


    public String create(PokerUser user) {
        try {
            return JWT.create()
                    .withClaim("userId", user.getId())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Can't create JWT.");
        }
    }

    public PokerUser find(String jwt) {
        try {
        DecodedJWT decodedJwt = verifier.verify(jwt);
        return pokerUserService.findById(decodedJwt.getClaim("userId").asLong());
    } catch (JWTVerificationException exception){
        return null;
    }
    }
}
