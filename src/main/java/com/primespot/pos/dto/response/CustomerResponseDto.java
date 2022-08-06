package com.primespot.pos.dto.response;

import lombok.*;

//Customer data comes through the customer response dto when getting a customer details.
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private int phoneNumber;
}
