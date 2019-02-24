package com.stackroute.exception;

//This Class handles Empty FileUrl exception
public class EmptyFileException extends Exception {
    private String message;

    public EmptyFileException(String message) {
        super(message);
        this.message = message;
    }
}
