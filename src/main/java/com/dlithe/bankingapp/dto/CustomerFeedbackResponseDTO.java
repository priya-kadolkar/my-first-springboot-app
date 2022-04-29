package com.dlithe.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerFeedbackResponseDTO {

    private String nameOfCustomer;
    private String feedbackMessage;
    private double ratings;
}
