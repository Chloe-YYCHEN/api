package com.example.api.repository;

import com.example.api.entity.Customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> getCustomers();
}
