package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkey";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Received authentication request");
        String username = getUser(authHeader);
        String token = generateJwt(username);
        LOGGER.debug("Generated JWT token for user {}: {}", username, token);
        return Collections.singletonMap("token", token);
    }

    private String getUser(String authHeader) {
        LOGGER.info("Extracting user from Authorization header");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.debug("Invalid Authorization header: {}", authHeader);
            throw new IllegalArgumentException("Authorization header must contain Basic credentials");
        }

        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        int delimiterIndex = credentials.indexOf(':');
        if (delimiterIndex < 0) {
            LOGGER.debug("Invalid Basic credentials value: {}", credentials);
            throw new IllegalArgumentException("Invalid Basic authentication token");
        }

        String username = credentials.substring(0, delimiterIndex);
        LOGGER.debug("Extracted username: {}", username);
        return username;
    }

    private String generateJwt(String user) {
        LOGGER.info("Generating JWT for user {}", user);
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);
        return builder.compact();
    }
}
