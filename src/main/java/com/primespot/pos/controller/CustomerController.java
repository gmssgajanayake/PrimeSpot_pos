package com.primespot.pos.controller;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;
import com.primespot.pos.service.CustomerService;
import com.primespot.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/primeSpot/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        String id = customerService.saveCustomer(customerRequestDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved !",id),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateCustomer
            (@RequestBody CustomerUpdateRequestDto customerRequestDto, @RequestParam String id) {
        customerService.updateCustomer(customerRequestDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer updated !", null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        "Customer deleted !",
                        null
                ), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> findCustomer(@RequestParam String email,@RequestParam String password) {
        CustomerResponseDto customer = customerService.findCustomer(email, password);
        if(customer == null){
            return new ResponseEntity<>(
                    new StandardResponse(
                            204,
                            "Customer found !",
                            null
                    ), HttpStatus.NO_CONTENT
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(
                            200,
                            "Customer found !",
                            customer
                    ), HttpStatus.OK
            );
        }
    }
}
