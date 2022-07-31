package com.primespot.pos.service;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;


public interface CustomerService {

    String saveCustomer(CustomerRequestDto customerRequestDto);

    void updateCustomer(CustomerUpdateRequestDto customerRequestDto, String id);

    void deleteCustomer(String id);

    CustomerResponseDto findCustomer(String email,String password);
}
