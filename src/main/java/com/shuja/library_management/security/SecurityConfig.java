package com.shuja.library_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth
                        // Authentication
                        .requestMatchers("/auth/register","/auth/login").permitAll()

                        // Public read acces
                        .requestMatchers(HttpMethod.GET, "/books/**", "/author/**").permitAll()

                        // Admin only book management
                        .requestMatchers(HttpMethod.POST, "/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")

                        // Admin only author management
                        .requestMatchers(HttpMethod.POST, "/authors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/authors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/authors/**").hasRole("ADMIN")

                        // member management
                        .requestMatchers("/member/**").hasRole("ADMIN")

                        // dashboard
                        .requestMatchers("/dashboard/**").hasRole("ADMIN")

                        .requestMatchers("/borrow/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated()
                )

                .addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

}

