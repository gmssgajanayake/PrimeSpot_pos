package com.primespot.pos.dto.response;

import lombok.*;

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
