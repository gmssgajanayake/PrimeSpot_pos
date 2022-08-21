package com.primespot.pos.service.impl;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;
import com.primespot.pos.entity.Customer;
import com.primespot.pos.repo.CustomerRepo;
import com.primespot.pos.service.CustomerService;
import com.primespot.pos.util.GeneratedIdentificationDto;
import com.primespot.pos.util.Generator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Customer service interface implementation.
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final Generator generator;
    private final PasswordEncoder passwordEncoder;

    //CustomerRepo,Generator and passwordEncoder are injected.
    public CustomerServiceImpl(CustomerRepo customerRepo, Generator generator) {
        this.customerRepo = customerRepo;
        this.generator = generator;
        this.passwordEncoder=new BCryptPasswordEncoder();
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
                passwordEncoder.encode(customerRequestDto.getPassword()),  //To encrypt the password
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
            customer.setPassword(passwordEncoder.encode(customerRequestDto.getPassword()));  //To encrypt the password
            customer.setAddress(customerRequestDto.getAddress());
            customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
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
            if (customer.getEmail().equalsIgnoreCase(email) &&
                    //To check whether the encrypted password is equal to the entered password
                    passwordEncoder.matches(password,customer.getPassword())){
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

    @Override
    public CustomerResponseDto findCustomer(String Id) {
        Customer customer = customerRepo.findById(Id).get();
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
