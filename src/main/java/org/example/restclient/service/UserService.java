package org.example.restclient.service;

import org.example.restclient.model.RequestUser;
import org.example.restclient.model.ResponseUser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class UserService {
    RestClient restClient;

    public UserService(RestClient.Builder restClientBuilder, @Value("${BASE_URL}") String baseUrl) {
        this.restClient = restClientBuilder
            .baseUrl(baseUrl)
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

    public ResponseEntity<Void> deleteUser(String page) {
        return restClient
            .delete()
            .uri("/users?page={page}", page)
            .retrieve()
            .toBodilessEntity();
    }
}
