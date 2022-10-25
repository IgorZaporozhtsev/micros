package com.example.jokes.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChuckNorrisJokesClient {

    private final static String url = "https://api.chucknorris.io/jokes/random";
    public final RestTemplate restTemplate;


    @Autowired
    public ChuckNorrisJokesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRandomJoke(){
        return restTemplate.getForEntity(url, String.class).getBody();
    }

}
