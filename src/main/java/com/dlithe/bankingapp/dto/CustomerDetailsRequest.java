package com.dlithe.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CustomerDetailsRequest {
    private String customerName;
    private String lastName;
    private String mobileNumber;
    private String address;
}
