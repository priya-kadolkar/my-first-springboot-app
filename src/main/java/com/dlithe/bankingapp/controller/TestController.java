package com.dlithe.bankingapp.controller;

import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /*@GetMapping("test")
    public String testingController(){

        return "Learning spring-boot!!";
    }*/

    @Autowired
    private TestService testService;

    @GetMapping("fetch-bank-details/{bankName}")
    public String displayBankDetails(@PathVariable String bankName){
       return testService.fetchBankDetails(bankName);

    }


    @GetMapping("login/{username}/{password}")
    public String loginDetails(@PathVariable String username,@PathVariable String password){
//        return "Username is: "+username+" "+"Password is: "+password;
        return testService.loginDetails(username,password);

    }

    /*
    @GetMapping("addition/{numberOne}/{numberTwo}/{numberThree}")
    public String additionOfTwoNumbers(@PathVariable int numberOne,@PathVariable int numberTwo,@PathVariable int numberThree){
        try {
            int result = numberOne + numberTwo + numberThree;
            return "The addition of three numbers is"+result;
        }catch (NumberFormatException ex){
            throw new NumberFormatException("Invalid input");
        }
    }*/
}


