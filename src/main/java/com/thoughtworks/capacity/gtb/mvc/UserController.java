package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void newUserRegister(@Valid @RequestBody User user) {
        userService.newUser(user);
    }

    @GetMapping("/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User userLoginIn(@RequestBody User user) {
        String name = user.getUserName();
        String password = user.getPassword();
        if (userService.isUserExistsAndPswCorrect(name, password)){
            return userService.getUserByUserName(name);
        }else{
            throw new UserNameOrPasswordNotFoundException("用户名或密码错误");
        }
    }
}
