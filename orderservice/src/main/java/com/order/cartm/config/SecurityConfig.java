package com.order.cartm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for H2 console
            .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll() // H2 console public
                .antMatchers(HttpMethod.GET, "/orders/all").authenticated() // GET /orders/all secured
                .anyRequest().permitAll() // everything else public
            .and()
            .headers().frameOptions().disable() // allow H2 console frames
            .and()
            .httpBasic(); // basic auth

        return http.build();
    }
}
