package com.ams.config;

 

import java.util.Arrays;

 

 

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

 

import com.ams.repository.StaffRepository;

 

@Configuration
@EnableWebSecurity(debug = false)
@EnableMethodSecurity
public class AmbulanceSecurityConfig {

 

    @Autowired
    AmbulanceAuthProvider ambulanceAuthProvider;

 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/amb").permitAll()
        .requestMatchers("/saveAmbulance/**").authenticated()
        .requestMatchers("/saveCaller/**").permitAll()
        .requestMatchers("/listallAmbulance/**").permitAll()
        .requestMatchers("/listAvailableAm/**").permitAll()
        .requestMatchers("/listallCaller/**").permitAll()
        .requestMatchers("/ActiveCaller/**").permitAll()
        .requestMatchers("/savehospital/**").authenticated()
        .requestMatchers("/listallHospital/**").permitAll()
        .requestMatchers("/saveStaff/**").authenticated()
        .requestMatchers("/listallStaff/**").permitAll()
        .requestMatchers("/StartTrip/**").permitAll()
        .requestMatchers("/EndTrip/**").permitAll()
        .requestMatchers("/listAllTrips/**").permitAll()        
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers("/v2/api-docs", "/v3/api-docs/**", "/swagger-resources/configuration/ui",
                        "/swagger-resources/configuration/security", "/webjars/**", "/swagger-ui.html",
                        "/swagger-ui/**")
                .permitAll();

 

        http.httpBasic();
        http.csrf().disable();
        return http.build();

 

    }

 

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);

 

        authenticationManagerBuilder.authenticationProvider(ambulanceAuthProvider);
        return authenticationManagerBuilder.build();
    }

 

    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.setExposedHeaders(Arrays.asList("Authorization"));
        config.setMaxAge((long) 3600000);
        source.registerCorsConfiguration("/**", config);
        return  new CorsFilter(source);
    }
}