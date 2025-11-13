package com.springsecurity.sec07.sevice;

import com.springsecurity.sec07.model.Customer;
import com.springsecurity.sec07.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer save(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return repository.save(customer);
    }
}
