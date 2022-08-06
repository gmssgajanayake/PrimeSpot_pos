package com.primespot.pos.service;

import com.primespot.pos.dto.requset.EmployerRequestDto;
import com.primespot.pos.dto.requset.EmployerUpdateRequestDto;
import com.primespot.pos.dto.response.EmployerResponseDto;

//All employer activities for dealing with database.
public interface EmployerService {

    //To save a new employer.
    String saveEmployer(EmployerRequestDto employerRequestDto);

    //To update an employer using ID.
    void updateEmployer(EmployerUpdateRequestDto employerRequestDto, String id);

    //To delete an employer using ID.
    void deleteEmployer(String id);

    //To find an employer using email and password.
    EmployerResponseDto findEmployer(String email,String password);
}
