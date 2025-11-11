package com.springsecurity.sec06.repository;

import com.springsecurity.sec06.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
