package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void newUserRegister(@Valid @RequestBody User user) {
        userService.newUser(user);
    }

    @GetMapping("/login")
    public User userLoginIn(@RequestBody User user) {
        String name = user.getUserName();
        String password = user.getPassword();
        return userService.isUserLegalAndPswLegal(name,password);
    }
}
