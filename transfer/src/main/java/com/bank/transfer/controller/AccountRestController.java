package com.bank.transfer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/")
public class AccountRestController {

    @GetMapping()
        public String hello (){
        return "привет создатель";
    }


}
