package com.springsecurity.sec06.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;
}
