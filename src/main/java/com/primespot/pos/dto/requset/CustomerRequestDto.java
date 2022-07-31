package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
