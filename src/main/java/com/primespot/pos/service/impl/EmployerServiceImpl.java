package com.primespot.pos.service.impl;

import com.primespot.pos.dto.requset.EmployerRequestDto;
import com.primespot.pos.dto.requset.EmployerUpdateRequestDto;
import com.primespot.pos.dto.response.EmployerResponseDto;
import com.primespot.pos.entity.Employer;
import com.primespot.pos.repo.EmployerRepo;
import com.primespot.pos.service.EmployerService;
import com.primespot.pos.util.GeneratedIdentificationDto;
import com.primespot.pos.util.Generator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final Generator generator;
    private final EmployerRepo employerRepo;

    public EmployerServiceImpl(Generator generator, EmployerRepo employerRepo) {
        this.generator = generator;
        this.employerRepo = employerRepo;
    }

    @Override
    public String saveEmployer(EmployerRequestDto employerRequestDto) {
        GeneratedIdentificationDto generatedIdentificationDto = generator.generatorID();
        return employerRepo.save(new Employer(
                generatedIdentificationDto.getPrefix() + "-E-" + generatedIdentificationDto.getId(),
                employerRequestDto.getName(),
                employerRequestDto.getEmail(),
                employerRequestDto.getPassword(),
                employerRequestDto.getAddress(),
                employerRequestDto.getSalary(),
                employerRequestDto.getPhoneNumber()
        )).getId();
    }

    @Override
    public void updateEmployer(EmployerUpdateRequestDto employerRequestDto, String id) {
        Optional<Employer> employerRecode = employerRepo.findById(id);
        if (employerRecode.isPresent()) {
            Employer employer = employerRecode.get();
            employer.setName(employerRequestDto.getName());
            employer.setPassword(employerRequestDto.getPassword());
            employer.setAddress(employerRequestDto.getAddress());
            employer.setSalary(employerRequestDto.getSalary());
            employerRepo.save(employer);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteEmployer(String id) {
        employerRepo.deleteById(id);
    }

    @Override
    public EmployerResponseDto findEmployer(String email, String password) {
        for (Employer employer: employerRepo.findAll()) {
            if (employer.getEmail().equalsIgnoreCase(email) && employer.getPassword().equalsIgnoreCase(password)){
                return new EmployerResponseDto(
                        employer.getId(),
                        employer.getName(),
                        employer.getEmail(),
                        employer.getPassword(),
                        employer.getAddress(),
                        employer.getSalary(),
                        employer.getPhoneNumber()
                );
            }
        }
        return null;
    }
}
