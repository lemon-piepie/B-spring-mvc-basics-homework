package com.thoughtworks.capacity.gtb.mvc;

public class UserExistErrorException extends RuntimeException {
    public UserExistErrorException(String message) {
        super(message);
    }
}
