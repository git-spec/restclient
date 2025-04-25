package org.example.restclient.controller;

import org.example.restclient.model.RequestUser;
import org.example.restclient.model.ResponseUser;
import org.example.restclient.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ResponseUser addUser(RequestUser user) {
        return service.addUser(user);
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> deleteUser(@RequestParam String page) {
        return service.deleteUser(page);
    }
}
