package com.example.tjv_project.controllers;

import com.example.tjv_project.api.model.CustomerDTO;
import com.example.tjv_project.entities.Customer;
import com.example.tjv_project.entities.Person;
import com.example.tjv_project.repositories.CustomerRepository;
import com.example.tjv_project.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CrudController<Customer, Long, CustomerService, CustomerRepository> {

    public CustomerController(CustomerService service) {
        super(service);
    }

}
