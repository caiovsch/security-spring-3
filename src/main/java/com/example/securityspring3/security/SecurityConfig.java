package com.example.securityspring3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                .requestMatchers(antMatcher("/static/**")).permitAll()
                .anyRequest().authenticated()
        );
        http.formLogin(login -> login
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/userAuth")
                .permitAll()
        );
        http.csrf().disable();
        return http.build();
    }
}
