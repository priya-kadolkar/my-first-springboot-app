package com.dlithe.bankingapp.serviceimplementation;

import com.dlithe.bankingapp.dto.CustomerDetailsRequest;
import com.dlithe.bankingapp.dto.CustomerDetailsResponse;
import com.dlithe.bankingapp.dto.CustomerFeedbackResponseDTO;
import com.dlithe.bankingapp.entity.Customer;
import com.dlithe.bankingapp.repository.CustomerDAO;
import com.dlithe.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        Optional<Customer> customer=customerDAO.findById(customerId);
        if(!customer.isPresent()){
            throw new NullPointerException("The requested customer is not found!!");
        }
        Customer customerFromDatabase=customer.get();

        CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
        customerDetailsResponse.setId(customerFromDatabase.getId());
        customerDetailsResponse.setName(customerFromDatabase.getName());
        customerDetailsResponse.setAge(customerFromDatabase.getAge());

        return customerDetailsResponse;
    }

    @Override
    public CustomerDetailsResponse fetchCustomerDetailsWithFeedback(int customerId) {
        Optional<Customer> customer=customerDAO.findById(customerId);
        Customer customerFromDatabase=customer.get();

        //created object for customer details response DTO to set and get values
        CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
        customerDetailsResponse.setId(customerFromDatabase.getId());
        customerDetailsResponse.setName(customerFromDatabase.getName());
        customerDetailsResponse.setAge(customerFromDatabase.getAge());

        //To set feedback field value in customer details response we need to create feedback response DTO object
        CustomerFeedbackResponseDTO feedbackResponseDTO=new CustomerFeedbackResponseDTO();
        feedbackResponseDTO.setNameOfCustomer("Priya");
        feedbackResponseDTO.setFeedbackMessage("The service is good");
        feedbackResponseDTO.setRatings(4.5);

        //to set feedback response data to Customer details response
        customerDetailsResponse.setFeedback(feedbackResponseDTO);

        return customerDetailsResponse;
    }

    @Override
    public CustomerDetailsResponse getCustomerDetailsWithAllFeedback(int customerId) {
        //List is used to store list of feedbacks in the customer details response
//        List<CustomerDetailsResponse> customerDetailsResponseList=new ArrayList<>();
        List<CustomerFeedbackResponseDTO> feedbacks=new ArrayList<>();

        Optional<Customer> customer=customerDAO.findById(customerId);
        Customer customerFromDatabase=customer.get();

        CustomerDetailsResponse customerDetailsResponse=new CustomerDetailsResponse();
        customerDetailsResponse.setId(customerFromDatabase.getId());
        customerDetailsResponse.setName(customerFromDatabase.getName());
        customerDetailsResponse.setAge(customerFromDatabase.getAge());

        //To set feedback field value in customer details response we need to create feedback response DTO object
        CustomerFeedbackResponseDTO feedbackResponseDTO=new CustomerFeedbackResponseDTO();
        feedbackResponseDTO.setNameOfCustomer("Priya");
        feedbackResponseDTO.setFeedbackMessage("The service is good");
        feedbackResponseDTO.setRatings(4.5);

        feedbacks.add(feedbackResponseDTO);

        CustomerFeedbackResponseDTO feedbackResponseDTO1=new CustomerFeedbackResponseDTO();
        feedbackResponseDTO1.setNameOfCustomer("Megha");
        feedbackResponseDTO1.setFeedbackMessage("Management is not good");
        feedbackResponseDTO1.setRatings(2.5);

        feedbacks.add(feedbackResponseDTO1);

        //adding list of feedbacks into the customer details
        customerDetailsResponse.setFeedbacks(feedbacks);
//        customerDetailsResponseList.add(customerDetailsResponse);

        return customerDetailsResponse;


    }
}
