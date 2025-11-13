package com.springsecurity.sec08.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Component
@Slf4j
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event){
        log.info("login successful, User: {}", event.getAuthentication().getName());
    }

    @EventListener
    public void onFailer(AbstractAuthenticationFailureEvent event){
        log.error("login failed, User: {}, reason: {}", event.getAuthentication().getName(), event.getException().getMessage());
    }
}
