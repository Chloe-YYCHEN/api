package com.example.api.repository;

import com.example.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
//spring.jackson.serialization.fail-on-empty-beans=false
//--app.useFakeCustomerRepo=false