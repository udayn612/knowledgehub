package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//This class is for handling exception globally
@ControllerAdvice
public class GlobalExceptionHandler {


    //This exception is when FileUrl is not Found
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity userAlreadyExistsException(final FileNotFoundException e) {
        return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //This exception is for checking Empty FileUrl
    @ExceptionHandler(EmptyFileException.class)
    public ResponseEntity userAlreadyExistsException(final EmptyFileException e) {
        return  new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
    }
}
