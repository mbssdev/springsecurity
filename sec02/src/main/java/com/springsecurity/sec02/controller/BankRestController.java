package com.springsecurity.sec02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : MajidBarzegar(majidbarzegar.a@gmail.com)
 */
@RestController
@RequestMapping("api/bank")
public class BankRestController {

    @GetMapping("contact")
    public String saveContact(){
        return "contact";
    }

    @GetMapping("notices")
    public String getNotices(){
        return "notices";
    }

    @GetMapping("account")
    public String getAccount(){
        return "account";
    }

    @GetMapping("balance")
    public String getBalance(){
        return "balance";
    }

    @GetMapping("loan")
    public String getLoan(){
        return "loan";
    }

    @GetMapping("card")
    public String getCard(){
        return "card";
    }
}
