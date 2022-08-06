package com.primespot.pos.service;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;

//All customer activities for dealing with database
public interface CustomerService {

    //To save a new customer.
    String saveCustomer(CustomerRequestDto customerRequestDto);

    //To update a customer using ID.
    void updateCustomer(CustomerUpdateRequestDto customerRequestDto, String id);

    //To delete a customer using ID.
    void deleteCustomer(String id);

    //To find a customer using email and password.
    CustomerResponseDto findCustomer(String email,String password);
}
