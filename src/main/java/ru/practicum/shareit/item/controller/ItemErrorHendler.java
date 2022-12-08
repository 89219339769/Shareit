package ru.practicum.shareit.item.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.shareit.exceptions.*;
import ru.practicum.shareit.item.validation.EmptyDescription;
import ru.practicum.shareit.user.model.ErrorResponse;

@RestControllerAdvice
public class ItemErrorHendler {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse  ObjectWrongEnterExeption(final NoAvailableException e) {
        return new ErrorResponse(e.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse  ObjectWrongEnterExeption(final NoItemNameException e) {
        return new ErrorResponse(e.getMessage());
    }



    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse  ObjectWrongEnterExeption(final EmptyItemDescriptionException e) {
        return new ErrorResponse(e.getMessage());
    }
}