package com.dlithe.bankingapp.serviceimplementation;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import com.dlithe.bankingapp.dto.CustomerDetailsResponse;
import com.dlithe.bankingapp.entity.Customer;
import com.dlithe.bankingapp.repository.CustomerDAO;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImplementation implements TestService {

    @Autowired
    private CustomerDAO customerDAO;

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

    @Override
    public String registerCustomer(CustomerDetailsRequest customerDetailsRequest) {

        Customer customer=new Customer();
        customer.setName(customerDetailsRequest.getName());
        customer.setAge(customerDetailsRequest.getAge());

        customerDAO.save(customer);
        return "User data saved successfully..";
    }

    @Override
    public CustomerDetailsResponse fetchCustomerDetails(int customerId) {
        Optional<Customer> customerDetails=customerDAO.findById(customerId);
        Customer customerFromDatabase=customerDetails.get();

        CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
        customerDetailsResponse.setId(customerFromDatabase.getId());
        customerDetailsResponse.setName(customerFromDatabase.getName());
        customerDetailsResponse.setAge(customerFromDatabase.getAge());

        return customerDetailsResponse;
    }
}
