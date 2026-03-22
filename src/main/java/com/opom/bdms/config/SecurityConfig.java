package com.opom.bdms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        private static final String[] PUBLIC_ENDPOINTS = {
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/api/v1/bdms/permissions/**",
                        "/api/v1/bdms/donors/**",
                        "/api/v1/bdms/bloodRequest/**"
                        "/api/v1/bdms/announcements/**",
                        "/api/v1/bdms/hospitals/**"                
        };

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(
                                                                PUBLIC_ENDPOINTS)
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .csrf(AbstractHttpConfigurer::disable);

                return http.build();
        }
}