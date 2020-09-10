package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult userValid(MethodArgumentNotValidException ex){
        return new ErrorResult(400, ex.getMessage());
    }

    @ExceptionHandler(UserNameOrPasswordNotMatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResult userOrPasswordNotFound(UserNameOrPasswordNotMatchException ex){
        return new ErrorResult(404, ex.getMessage());
    }

    @ExceptionHandler(IllegalUserNameException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult userInvalid(IllegalUserNameException ex){
        return new ErrorResult(400, ex.getMessage());
    }

    @ExceptionHandler(IllegalPasswordException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult passwordInvalid(IllegalPasswordException ex){
        return new ErrorResult(400, ex.getMessage());
    }
}
