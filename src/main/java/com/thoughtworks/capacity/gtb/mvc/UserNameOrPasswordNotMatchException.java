package com.thoughtworks.capacity.gtb.mvc;

public class UserNameOrPasswordNotMatchException extends RuntimeException{
    public UserNameOrPasswordNotMatchException() {
        super("用户名或密码错误");
    }
}
