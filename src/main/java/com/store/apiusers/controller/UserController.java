package com.store.apiusers.controller;

import com.store.apiusers.model.User;
import com.store.apiusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store/v1/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User newUser) {
        User user = this.service.createUser(newUser);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<User> getById(@PathVariable String id) {
        User user = service.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
