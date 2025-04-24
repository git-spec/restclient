package org.example.restclient.service;

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
}
