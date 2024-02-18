package com.example.tjv_project.controllers;

import com.example.tjv_project.entities.EntityWithId;
import com.example.tjv_project.services.CrudService;
import com.example.tjv_project.services.EntityCannotBeCreatedException;
import com.example.tjv_project.services.EntityDoesNotExistException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public abstract class CrudController<E extends EntityWithId<ID>, ID, S extends CrudService<E , ID, R>, R extends CrudRepository<E, ID>> {
    protected S service;

    public CrudController(S service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public E create(@RequestBody E data){
            return service.create(data);
    }

    @GetMapping
    @ResponseBody
    public Iterable<E> readAll(){
        return service.readAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public E readById(@PathVariable ID id){
        var optE = service.readById(id);
        return optE.get();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable ID id, @RequestBody E data){
            service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id){
            service.deleteById(id);
    }
}
