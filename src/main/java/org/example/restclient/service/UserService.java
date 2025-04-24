package org.example.restclient.service;

import org.example.restclient.model.RequestUser;
import org.example.restclient.model.ResponseUser;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class UserService {
    RestClient restClient;

    public UserService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
            .baseUrl("https://reqres.in/api")
            .build();
    }

    public ResponseUser addUser(RequestUser user) {
        return restClient
            .post()
            .uri("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .body(user)
            .retrieve()
            .body(ResponseUser.class);
    }
}
