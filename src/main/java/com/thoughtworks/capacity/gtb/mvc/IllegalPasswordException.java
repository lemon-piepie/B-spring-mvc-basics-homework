package com.thoughtworks.capacity.gtb.mvc;

public class IllegalPasswordException extends RuntimeException {
    public IllegalPasswordException(String message) {
        super(message);
    }
}
