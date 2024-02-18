package com.example.tjv_project.services;

import com.example.tjv_project.entities.Customer;
import com.example.tjv_project.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends CrudService<Customer, Long, CustomerRepository>{
    public CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
