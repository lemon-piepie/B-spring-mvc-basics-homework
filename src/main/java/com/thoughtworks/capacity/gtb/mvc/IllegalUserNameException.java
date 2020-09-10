package com.thoughtworks.capacity.gtb.mvc;

public class IllegalUserNameException extends RuntimeException {
    public IllegalUserNameException() {
        super("用户名不合法");
    }
}
