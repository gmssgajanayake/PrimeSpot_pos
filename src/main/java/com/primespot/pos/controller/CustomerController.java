package com.primespot.pos.controller;

import com.primespot.pos.dto.requset.CustomerRequestDto;
import com.primespot.pos.dto.requset.CustomerUpdateRequestDto;
import com.primespot.pos.dto.response.CustomerResponseDto;
import com.primespot.pos.service.CustomerService;
import com.primespot.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//The Customer Controller class is created to control each customer.
@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    //Customer service is injected
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //To save a new customer
    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        String id = customerService.saveCustomer(customerRequestDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved !",id),
                HttpStatus.CREATED
        );
    }

    //To update a customer using ID
    @PutMapping
    public ResponseEntity<StandardResponse> updateCustomer
            (@RequestBody CustomerUpdateRequestDto customerRequestDto, @RequestParam String id) {
        customerService.updateCustomer(customerRequestDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer updated !", null),
                HttpStatus.CREATED
        );
    }

    //To delete a customer using ID
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

    /* To find a customer who has already registered in our system.
     * This method is created to find the account when a customer is going to log in to the customer's
     (her/his) account in the login form using (her/his) email and password.*/
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
