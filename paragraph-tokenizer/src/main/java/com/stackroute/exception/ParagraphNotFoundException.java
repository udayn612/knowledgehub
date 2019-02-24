/*
This is the exception class in case a paragraph is not found.
 */

package com.stackroute.exception;

public class ParagraphNotFoundException extends Exception {
    private String message;

    public ParagraphNotFoundException() {
    }

    public ParagraphNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
