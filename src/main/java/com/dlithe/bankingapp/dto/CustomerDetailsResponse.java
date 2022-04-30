package com.dlithe.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerDetailsResponse {

    private int id;
    private String name;
    private int age;

    //adding Customer feedback response dto as a field
    private CustomerFeedbackResponseDTO feedback;

    //
    private List<CustomerFeedbackResponseDTO> feedbacks;
}
