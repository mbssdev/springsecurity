package com.springsecurity.sec08.exceptionhandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("error reason", "Access denied");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        String unauthorizedResponse = """
                {
                    "message": "%s",
                    "path": "%s"
                }
                """;
        response.getWriter().write(String.format(unauthorizedResponse, "access denied", request.getRequestURI()));
    }
}
