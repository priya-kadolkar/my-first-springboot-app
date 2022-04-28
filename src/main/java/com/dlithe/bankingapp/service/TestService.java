package com.dlithe.bankingapp.service;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import com.dlithe.bankingapp.dto.CustomerDetailsResponse;
import org.springframework.stereotype.Component;

@Component
public interface TestService {

    String fetchBankDetails(String bankName);

    //Get type is used
    String loginDetails(String username, String password);

    //posting type is used for this method
    String registerCustomer(CustomerDetailsRequest customerDetailsRequest);

    CustomerDetailsResponse fetchCustomerDetails(int customerId);
}
