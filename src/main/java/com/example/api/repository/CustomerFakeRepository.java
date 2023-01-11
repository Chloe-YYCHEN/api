package com.example.api.repository;

import com.example.api.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,"James Bond","email@gmail.com"),
                new Customer(2L,"Jamila Ahmed","email@gmail.com")
        );
    }
}