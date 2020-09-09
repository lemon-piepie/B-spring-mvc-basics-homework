package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserServic userServic;

    public UserController(UserServic userServic) {
        this.userServic = userServic;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return this.userServic.getAllUsers();
    }
}
