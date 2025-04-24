package org.example.restclient.controller;

import org.example.restclient.service.UserService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
}
