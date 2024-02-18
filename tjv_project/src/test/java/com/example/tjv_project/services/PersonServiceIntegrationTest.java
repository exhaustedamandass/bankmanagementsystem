package com.example.tjv_project.services;

import com.example.tjv_project.entities.Person;
import com.example.tjv_project.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersonServiceIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    void testCreatePerson() {
        Person person = new Person();
        Person createdPerson = personService.create(person);

        assertNotNull(createdPerson.getId());
        assertEquals(person, createdPerson);
    }

    @Test
    void testReadAllPersons() {
        Person person1 = new Person();
        Person person2 = new Person();
        personRepository.saveAll(List.of(person1, person2));

        Iterable<Person> result = personService.readAll();

        assertNotNull(result);
        //4 because there is already 2 persons added from data.sql
        assertEquals(4, ((Collection<?>) result).size());
    }

    @Test
    void testReadPersonById() {
        Person person = new Person();
        personRepository.save(person);

        Long personId = person.getId();
        Optional<Person> result = personService.readById(personId);

        assertTrue(result.isPresent());
        assertEquals(person, result.get());
    }

    @Test
    void testUpdatePerson() {
        Person existingPerson = new Person();
        personRepository.save(existingPerson);

        Long personId = existingPerson.getId();
        Person updatedPerson = new Person();
        personService.update(personId, updatedPerson);

        Optional<Person> result = personRepository.findById(personId);
        assertTrue(result.isPresent());
        assertEquals(updatedPerson, result.get());
    }

    @Test
    void testDeletePersonById() {
        Person person = new Person();
        personRepository.save(person);

        Long personId = person.getId();
        personService.deleteById(personId);

        assertFalse(personRepository.existsById(personId));
    }
}

