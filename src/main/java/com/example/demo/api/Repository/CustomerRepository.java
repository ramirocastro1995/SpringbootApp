package com.example.demo.api.Repository;

import com.example.demo.api.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> { }
