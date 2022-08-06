package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//The request body of the customer controller when a new customer is going to register in the system
@Data
@Getter
@Setter
public class CustomerRequestDto {
    private String name;
    private String email;
    private String password;
    private String address;
    private int phoneNumber;
}
