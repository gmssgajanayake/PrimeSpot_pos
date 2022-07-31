package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployerUpdateRequestDto {
    private String name;
    private String password;
    private String address;
    private int salary;
    private int phoneNumber;
}
