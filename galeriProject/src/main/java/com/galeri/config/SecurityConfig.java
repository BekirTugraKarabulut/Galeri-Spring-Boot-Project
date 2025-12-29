package com.galeri.config;

import com.galeri.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String REFRESH_TOKEN = "/refresh-token";
    public static final String GALERICI_REGISTER = "/galerici/auth/kayit";
    public static final String GALERICI_LOGIN = "/galerici/auth/giris";
    public static final String GALERICI_REFRESH_TOKEN = "/galerici/auth/refresh-token";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((request) -> request
                    .requestMatchers(
                            REGISTER,
                            LOGIN,
                            REFRESH_TOKEN,
                            GALERICI_LOGIN,
                            GALERICI_REGISTER,
                            GALERICI_REFRESH_TOKEN,
                            "/marka/**",
                            "/model/**",
                            "/favorileme/**",
                            "/kullanici/update/{username}",
                            "/randevu/**",
                            "/randevu/randevuAl",
                            "/upload/image",
                            "/uploads/**",
                            "/araclar",
                            "/arac-ekle",
                            "/kullanici/get/{username}",
                            "/v3/api-docs/**",
                            "/swagger-ui/**",
                            "/swagger-ui.html")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
                .exceptionHandling((exception) -> exception.authenticationEntryPoint(authenticationEntryPoint))
                .authenticationProvider(authenticationProvider)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter , UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
