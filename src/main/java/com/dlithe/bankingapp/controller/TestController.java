package com.dlithe.bankingapp.controller;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import com.dlithe.bankingapp.dto.CustomerDetailsResponse;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Getting customer details with one feedback
    @GetMapping("get-customer-details-with-feedback/{customerId}")
    public CustomerDetailsResponse fetchDetailsWithOneFeedback(@PathVariable int customerId){
        return testService.fetchCustomerDetailsWithFeedback(customerId);
    }

    //To get all the customer details with list of feedbacks
    @GetMapping("get-customers-details/{customerId}")
    public CustomerDetailsResponse getDetailsWithAllFeedbacks(@PathVariable int customerId){
        return testService.getCustomerDetailsWithAllFeedback(customerId);
    }

    //fetching data based on name
    @GetMapping("fetch-customer-details/{customerName}")
    public CustomerDetailsResponse getCustomerDetailsByName(@PathVariable String customerName){
        return testService.fetchCustomerDetailsByName(customerName);
    }

    //fetching customer details based on id and name
    @GetMapping("fetch-customer-details-by-id-name/{customerId}/{customerName}")
    public CustomerDetailsResponse getCustomerDetailsByIdAndName(@PathVariable int customerId,@PathVariable String customerName){
        return testService.fetchCustomerDetailsByIdAndName(customerId,customerName);
    }


}


