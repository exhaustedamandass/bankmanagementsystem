package com.example.tjv_project.services;
import com.example.tjv_project.entities.Person;
import com.example.tjv_project.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PersonServiceUnitTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testCreatePerson() {
        Person person = new Person();
        when(personRepository.save(any())).thenReturn(person);

        Person createdPerson = personService.create(person);

        assertNotNull(createdPerson);
    }

    @Test
    void testReadAllPersons() {
        List<Person> personList = new ArrayList<>();
        when(personRepository.findAll()).thenReturn(personList);

        Iterable<Person> result = personService.readAll();

        assertNotNull(result);
    }

    @Test
    void testReadPersonById() {
        Long personId = 1L;
        Person person = new Person();
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        Optional<Person> result = personService.readById(personId);

        assertTrue(result.isPresent());
    }

    @Test
    void testUpdatePerson() {
        Long personId = 1L;
        Person existingPerson = new Person();
        when(personRepository.existsById(personId)).thenReturn(true);
        when(personRepository.save(any())).thenReturn(existingPerson);

        Person updatedPerson = new Person();
        personService.update(personId, updatedPerson);

    }

    @Test
    void testDeletePersonById() {
        Long personId = 1L;
        when(personRepository.existsById(personId)).thenReturn(true);

        assertDoesNotThrow(() -> personService.deleteById(personId));
    }
}
