package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Configuring in-memory authentication users");
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
        LOGGER.debug("Configured in-memory users admin and user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Configuring HTTP security rules");
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/authenticate").hasAnyRole("ADMIN", "USER")
                    .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.addFilter(new JwtAuthorizationFilter(authenticationManager()));
        LOGGER.debug("Registered JwtAuthorizationFilter and security rules");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        LOGGER.info("Creating BCryptPasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }
}
