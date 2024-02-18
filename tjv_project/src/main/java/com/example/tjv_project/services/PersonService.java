package com.example.tjv_project.services;

import com.example.tjv_project.entities.Person;
import com.example.tjv_project.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends CrudService<Person, Long, PersonRepository>{
    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
