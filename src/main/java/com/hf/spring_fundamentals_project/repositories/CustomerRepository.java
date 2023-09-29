package com.hf.spring_fundamentals_project.repositories;

import com.hf.spring_fundamentals_project.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}