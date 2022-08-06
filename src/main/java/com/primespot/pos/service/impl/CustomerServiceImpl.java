package com.primespot.pos.service.impl;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;
import com.primespot.pos.entity.Customer;
import com.primespot.pos.repo.CustomerRepo;
import com.primespot.pos.service.CustomerService;
import com.primespot.pos.util.GeneratedIdentificationDto;
import com.primespot.pos.util.Generator;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Customer service interface implementation.
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final Generator generator;

    //CustomerRepo and Generator is injected.
    public CustomerServiceImpl(CustomerRepo customerRepo, Generator generator) {
        this.customerRepo = customerRepo;
        this.generator = generator;
    }

    //To save a new customer.
    @Override
    public String saveCustomer(CustomerRequestDto customerRequestDto) {
        //To generator an id.
        GeneratedIdentificationDto generatedIdentificationDto = generator.generatorID();

        return customerRepo.save(new Customer(
                generatedIdentificationDto.getPrefix() + "-C-" + generatedIdentificationDto.getId(),
                customerRequestDto.getName(),
                customerRequestDto.getEmail(),
                customerRequestDto.getPassword(),
                customerRequestDto.getAddress(),
                customerRequestDto.getPhoneNumber()
        )).getId();
    }

    //To update a customer using ID
    @Override
    public void updateCustomer(CustomerUpdateRequestDto customerRequestDto, String id) {
        Optional<Customer> customerRecode = customerRepo.findById(id);
        if (customerRecode.isPresent()) {
            Customer customer = customerRecode.get();
            customer.setName(customerRequestDto.getName());
            customer.setPassword(customerRequestDto.getPassword());
            customer.setAddress(customerRequestDto.getAddress());
            customer.setPassword(customer.getPassword());
            customerRepo.save(customer);
        } else {
            throw new RuntimeException();
        }
    }

    //To delete a customer using ID
    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);
    }

    //To find a customer using email and password
    @Override
    public CustomerResponseDto findCustomer(String email, String password) {
        for (Customer customer: customerRepo.findAll()) {
            if (customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equalsIgnoreCase(password)){
                return new CustomerResponseDto(
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPassword(),
                        customer.getAddress(),
                        customer.getPhoneNumber()
                );
            }
        }
    return null;
    }


}
