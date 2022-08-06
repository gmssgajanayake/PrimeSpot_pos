package com.primespot.pos.controller;

import com.primespot.pos.dto.requset.EmployerRequestDto;
import com.primespot.pos.dto.requset.EmployerUpdateRequestDto;
import com.primespot.pos.dto.response.EmployerResponseDto;
import com.primespot.pos.service.EmployerService;
import com.primespot.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//The Employer Controller class is created to control each our employers.
@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class EmployerController {
    private final EmployerService employerService;

    //Employer service is injected
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    //To save a new employer
    @PostMapping
    public ResponseEntity<StandardResponse> saveEmployer(@RequestBody EmployerRequestDto employerRequestDto) {
        String id = employerService.saveEmployer(employerRequestDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Employer saved !",id),
                HttpStatus.CREATED
        );
    }

    //To update an employer using ID
    @PutMapping
    public ResponseEntity<StandardResponse> updateEmployer
            (@RequestBody EmployerUpdateRequestDto employerRequestDto, @RequestParam String id) {
        employerService.updateEmployer(employerRequestDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Employer updated !", null),
                HttpStatus.CREATED
        );
    }

    //To delete an employer using ID
    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteEmployer(@RequestParam String id) {
        employerService.deleteEmployer(id);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        "Employer deleted !",
                        null
                ), HttpStatus.NO_CONTENT
        );
    }

    /* To find an employer who has already registered in our system.
     *  This method is created to find the account when an employer is going to log in to the employer's
     (her/his) account in the login form using (her/his) email and password.*/
    @GetMapping
    public ResponseEntity<StandardResponse> findEmployer(@RequestParam String email,@RequestParam String password) {
        EmployerResponseDto employer = employerService.findEmployer(email, password);
        if(employer == null){
            return new ResponseEntity<>(
                    new StandardResponse(
                            204,
                            "Employer found !",
                            null
                    ), HttpStatus.NO_CONTENT
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(
                            200,
                            "Employer found !",
                            employer
                    ), HttpStatus.OK
            );
        }
    }
}
