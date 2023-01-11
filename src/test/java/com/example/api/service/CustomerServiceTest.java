package com.example.api.service;

import com.example.api.entity.Customer;
import com.example.api.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L,
                "jamila",
                "1111",
                "1234@qq.com");
        Customer Amy = new Customer(2L,
                "Amy",
                "1111",
                "1234@qq.com");
        customerRepository.saveAll(Arrays.asList(jamila,Amy));
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer jamila = new Customer(1L,
                "jamila",
                "hello",
                "1234@qq.com");
        customerRepository.save(jamila);
        //when
        Customer actual = underTest.getCustomer(1L);
        //then
        assertEquals(1L,actual.getId());
        assertEquals("jamila",actual.getName());
        assertEquals("hello",actual.getPassword());
        assertEquals("1234@qq.com",actual.getEmail());
    }
}