package com.primespot.pos.repo;

import com.primespot.pos.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployerRepo extends JpaRepository<Employer,String> { }

