package com.news.app.Common.config;

import com.news.app.Common.constant.Roles;
import com.news.app.Common.utils.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                    authRequest ->
                        authRequest.requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/news/**").permitAll()
                                .requestMatchers("/admin/**").hasRole(Roles.ADMINISTRATOR.name())
                                .requestMatchers("/journalist/**").hasRole(Roles.JOURNALIST.name())  // Only journalists can create/edit news
                                .requestMatchers("/publisher/**").hasRole(Roles.PUBLISHER.name())    // Only publishers can review/publish
                                .requestMatchers("/reader/**").hasRole(Roles.READERS.name())         // Readers need to be logged in to subscribe
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManger -> sessionManger.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    
}