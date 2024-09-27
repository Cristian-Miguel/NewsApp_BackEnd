package com.news.app.Common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.management.relation.Role;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(
                authRequest ->
                        authRequest.requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/news/**").permitAll()
                                .requestMatchers("/journalist/**").hasRole(Roles.JOURNALIST.toString())  // Only journalists can create/edit news
                                .requestMatchers("/publisher/**").hasRole(Roles.PUBLISHER.toString())    // Only publishers can review/publish
                                .requestMatchers("/reader/**").hasRole(Roles.READERS.toString())         // Readers need to be logged in to subscribe
                                .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults())
                .build();
    }
    
}