package com.springsecurity.sec08.config;

import com.springsecurity.sec08.exceptionhandling.CustomAccessDeniedHandler;
import com.springsecurity.sec08.exceptionhandling.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Configuration
@Profile("dev")
public class DevSecurityConfiguration {

    private final List<String> publicApis = List.of("/api/bank/contact", "/api/bank/notices", "/api/bank/register-account", "/api/bank/invalid-session");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(configurer -> configurer
                        .sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::changeSessionId)
                        .invalidSessionUrl("/api/bank/invalid-session")
                        .maximumSessions(2).maxSessionsPreventsLogin(true)
                )
                .requiresChannel(cr -> cr.anyRequest().requiresInsecure()) // only http
                .csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((requests) ->
                requests
                        .requestMatchers(publicApis.toArray(new String[0])).permitAll()
                        .anyRequest().authenticated()
        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(configurer -> configurer.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(configurer -> configurer
                        .accessDeniedHandler(new CustomAccessDeniedHandler())
//                .authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint())
        );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
