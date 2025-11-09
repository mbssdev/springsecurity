package com.springsecurity.sec04.controller;

import com.springsecurity.sec04.model.Customer;
import com.springsecurity.sec04.sevice.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@RestController
@RequestMapping("api/bank")
@RequiredArgsConstructor
public class BankRestController {

    private final CustomerService customerService;

    @PostMapping("register-account")
    public ResponseEntity<String> registerAccount(@RequestBody Customer customer) {
        try {
            customerService.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("successful registration");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed registration");
        }
    }

    @GetMapping("contact")
    public String saveContact() {
        return "contact";
    }

    @GetMapping("notices")
    public String getNotices() {
        return "notices";
    }

    @GetMapping("account")
    public String getAccount() {
        return "account";
    }

    @GetMapping("balance")
    public String getBalance() {
        return "balance";
    }

    @GetMapping("loan")
    public String getLoan() {
        return "loan";
    }

    @GetMapping("card")
    public String getCard() {
        return "card";
    }
}
