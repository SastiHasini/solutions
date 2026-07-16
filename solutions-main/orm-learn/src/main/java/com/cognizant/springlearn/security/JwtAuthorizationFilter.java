package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private static final String SECRET_KEY = "secretkey";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        LOGGER.info("JwtAuthorizationFilter processing request {}", request.getRequestURI());

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            LOGGER.debug("No Bearer token found in Authorization header");
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
        if (authentication == null) {
            LOGGER.debug("Failed to create authentication from JWT");
            chain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        LOGGER.debug("Authenticated user {} from JWT", authentication.getName());
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer ".length());
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String user = claims.getSubject();
            if (user != null) {
                LOGGER.info("JWT parsed successfully for user {}", user);
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        } catch (Exception ex) {
            LOGGER.error("JWT token validation failed: {}", ex.getMessage());
        }
        return null;
    }
}
