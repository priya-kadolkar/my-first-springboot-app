package com.dlithe.bankingapp.controller;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import com.dlithe.bankingapp.dto.CustomerDetailsResponse;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("fetch-bank-details/{bankName}")
    public String displayBankDetails(@PathVariable String bankName) {
        return testService.fetchBankDetails(bankName);

    }


    @GetMapping("login/{username}/{password}")
    public String loginDetails(@PathVariable String username, @PathVariable String password) {
//        return "Username is: "+username+" "+"Password is: "+password;
        return testService.loginDetails(username, password);

    }

    @PostMapping("register-customer")
    public String registerNewCustomer(@RequestBody CustomerDetailsRequest customerDetailsRequest){
        return testService.registerCustomer(customerDetailsRequest);
    }

    //Getting customer details based on their customer id
    @GetMapping("get-customer-details/{customerId}")
    public CustomerDetailsResponse fetchDetails(@PathVariable int customerId){
        return testService.fetchCustomerDetails(customerId);
    }

}


