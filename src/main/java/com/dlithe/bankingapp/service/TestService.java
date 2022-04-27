package com.dlithe.bankingapp.service;

import org.springframework.stereotype.Component;

@Component
public interface TestService {

    String fetchBankDetails(String bankName);

    String loginDetails(String username, String password);
}
