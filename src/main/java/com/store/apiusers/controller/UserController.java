package com.store.apiusers.controller;

import com.store.apiusers.model.Credentials;
import com.store.apiusers.model.User;
import com.store.apiusers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("store/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User newUser) {
        User user = this.service.createUser(newUser);
        return new ResponseEntity<User>(user, CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<User> getById(@PathVariable String id) {
        User user = service.getUserById(id);
        return new ResponseEntity<User>(user, OK);
    }

    @PostMapping("/login")
    public void login(@RequestBody Credentials credentials) {
        service.verifyCredentials(credentials);
        ResponseEntity.ok().build();
    }

}
