package com.dlithe.bankingapp.serviceimplementation;

import com.dlithe.bankingapp.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImplementation implements TestService {
    @Override
    public String fetchBankDetails(String bankName) {
        if(bankName!=null){
            switch (bankName){
                case "SBI":
                    return "State Bank of India";
                case "CBI":
                    return "Central Bank of India";
                case "BB":
                    return "Bank of Baroda";
                default:
                    return "No details found";
            }
        }
        else {
            return "Cannot pass the null value";
        }
    }

    @Override
    public String loginDetails(String username, String password) {
        if(username!= null && password!=null){
           return  "Username: "+username+" "+"Password: "+password;
        }
        else {
            return "No values to return";
        }
    }
}
