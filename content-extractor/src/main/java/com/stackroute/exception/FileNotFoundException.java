package com.stackroute.exception;


//This Class handles FileUrl Not Found exception
public class FileNotFoundException extends Exception{
    private String message;

    public FileNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
