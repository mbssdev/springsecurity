package com.springsecurity.sec08.exceptionhandling;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
public class CustomBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setHeader("error reason", "Authentication failed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");
        String unauthorizedResponse = """
                {
                    "message": "%s",
                    "path": "%s"
                }
                """;
        response.getWriter().write(String.format(unauthorizedResponse, "error in authentication", request.getRequestURI()));
    }
}
