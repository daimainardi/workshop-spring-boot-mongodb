package com.daimainardi.workshopmongo.resource;

import com.daimainardi.workshopmongo.domain.User;
import com.daimainardi.workshopmongo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}
