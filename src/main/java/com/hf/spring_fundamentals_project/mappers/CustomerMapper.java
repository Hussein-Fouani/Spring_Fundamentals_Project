package com.hf.spring_fundamentals_project.mappers;

import com.hf.spring_fundamentals_project.entities.Customer;
import com.hf.spring_fundamentals_project.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);

}