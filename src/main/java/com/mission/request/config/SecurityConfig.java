//package com.mission.request.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig{
//
//    SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
//        return http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/").permitAll();
//                    auth.anyRequest().authenticated();
//                })
//                .build();
//    }
//
//
//}
