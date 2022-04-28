package com.dlithe.bankingapp.service;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import org.springframework.stereotype.Component;

@Component
public interface TestService {

    String fetchBankDetails(String bankName);

    String loginDetails(String username, String password);

    String registerCustomer(CustomerDetailsRequest customerDetailsRequest);
}
