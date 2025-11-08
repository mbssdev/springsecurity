package com.springsecurity.sec02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Configuration
public class SecurityConfiguration {

    private final List<String> publicApis = List.of("api/bank/contact", "api/bank/notices");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests
                        .requestMatchers(publicApis.toArray(new String[0])).permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
