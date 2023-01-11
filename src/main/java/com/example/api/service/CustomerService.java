package com.example.api.service;

import com.example.api.entity.Customer;
import com.example.api.exception.NotFoundException;
import com.example.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomers(){
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () ->{
                        NotFoundException notFoundException = new NotFoundException(
                                "customer with id" + id + "not found");
                            log.error("error in getting customer {}",id);
                            return notFoundException;
                        });
    }
}
