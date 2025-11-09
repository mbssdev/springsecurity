package com.springsecurity.sec04.repository;

import com.springsecurity.sec04.model.Customer;
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
