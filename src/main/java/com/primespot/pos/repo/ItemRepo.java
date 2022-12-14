package com.primespot.pos.repo;

import com.primespot.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//DB connection with hibernate

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,String> {
}
