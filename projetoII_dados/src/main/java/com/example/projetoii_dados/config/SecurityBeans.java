package com.example.projetoii_dados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityBeans {

    /** BCrypt para gerar/verificar o password_hash */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** Desliga autenticação global, mas mantém regras prontas para futuro */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // sem CSRF porque é API stateless; remove se precisares
                .csrf(csrf -> csrf.disable())

                // não cria sessão HTTP
                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        // Swagger totalmente livre
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // resto das rotas também livre (muda para authenticated() quando quiseres)
                        .anyRequest().permitAll())

                // desliga Basic-Auth/form-login automáticos
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(form -> form.disable());

        return http.build();
    }
}
