package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//The request body of the employer controller when a new employer is going to register in the system
@Data
@Getter
@Setter
public class EmployerRequestDto {
    private String name;
    private String email;
    private String password;
    private String address;
    private int salary;
    private int phoneNumber;
}
