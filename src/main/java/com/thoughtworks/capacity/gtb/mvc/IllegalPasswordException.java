package com.thoughtworks.capacity.gtb.mvc;

public class IllegalPasswordException extends RuntimeException {
    public IllegalPasswordException() {
        super("密码不合法");
    }
}
