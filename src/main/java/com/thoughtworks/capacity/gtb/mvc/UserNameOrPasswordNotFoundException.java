package com.thoughtworks.capacity.gtb.mvc;

public class UserNameOrPasswordNotFoundException extends RuntimeException{
    public UserNameOrPasswordNotFoundException(String message) {
        super(message);
    }
}
