package com.thoughtworks.capacity.gtb.mvc;

public class IllegalUserNameException extends RuntimeException {
    public IllegalUserNameException(String message) {
        super(message);
    }
}
