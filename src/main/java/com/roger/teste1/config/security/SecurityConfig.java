package com.roger.teste1.config.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

/**
 * Responsável pelas configurações de segurança da aplicação.
 *
 * @author Janilson Serra, Alfredo Gabriel
 * @since 23/01/2023
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

                return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                                .anonymous(AbstractHttpConfigurer::disable)
                                .formLogin(forms -> forms.disable())
                                .httpBasic(basic -> basic.disable())
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .exceptionHandling(exeption -> exeption
                                                .authenticationEntryPoint(
                                                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                                .authorizeHttpRequests(authorize -> authorize
                                                .anyRequest()
                                                .permitAll())
                                .build();

        }

        @Bean
        CorsConfigurationSource corsConfigurationSource() {
                CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedHeaders(List.of("Authorization"));
                configuration.setAllowCredentials(true);
                configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type", "Content-Type",
                                "Access-Control-Allow-Headers", "Access-Control-Allow-Origin"));
                configuration.setExposedHeaders(
                                Arrays.asList("X-Get-Header", "Access-Control-Allow-Methods",
                                                "Access-Control-Allow-Origin"));
                configuration.setAllowedMethods(Collections.singletonList("*"));

                final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", configuration);
                return source;
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
}
