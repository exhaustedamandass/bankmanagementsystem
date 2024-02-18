package com.example.tjv_project.controllers;

import com.example.tjv_project.services.EntityCannotBeCreatedException;
import com.example.tjv_project.services.EntityDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionsHandlers {
    @ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound(){}

    @ExceptionHandler(EntityCannotBeCreatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleConflict(){}
}
