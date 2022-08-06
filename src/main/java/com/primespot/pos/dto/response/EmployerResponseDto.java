package com.primespot.pos.dto.response;

import lombok.*;

//Employer data comes through the employer response dto when getting an employer details.
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
