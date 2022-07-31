package com.primespot.pos.service;

import com.primespot.pos.dto.requset.EmployerRequestDto;
import com.primespot.pos.dto.requset.EmployerUpdateRequestDto;
import com.primespot.pos.dto.response.EmployerResponseDto;

public interface EmployerService {

    String saveEmployer(EmployerRequestDto employerRequestDto);

    void updateEmployer(EmployerUpdateRequestDto employerRequestDto, String id);

    void deleteEmployer(String id);

    EmployerResponseDto findEmployer(String email,String password);
}
