package com.primespot.pos.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResponseDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private int salary;
    private int phoneNumber;
}
