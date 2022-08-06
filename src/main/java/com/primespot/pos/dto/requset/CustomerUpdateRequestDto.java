package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//The request body of the customer controller when a customer is going to update account
@Data
@Getter
@Setter
public class CustomerUpdateRequestDto {
    private String name;
    private String password;
    private String address;
    private int phoneNumber;
}
