package com.example.tjv_project.controllers;

import com.example.tjv_project.api.model.CustomerDTO;
import com.example.tjv_project.entities.Person;
import com.example.tjv_project.repositories.PersonRepository;
import com.example.tjv_project.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController extends CrudController<Person, Long, PersonService, PersonRepository>{

    public PersonController(PersonService service) {
        super(service);
    }

}
