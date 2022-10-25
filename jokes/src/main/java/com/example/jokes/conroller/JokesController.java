package com.example.jokes.conroller;

import com.example.jokes.client.ChuckNorrisJokesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jokes")
public class JokesController {

    private final ChuckNorrisJokesClient client;

    @Autowired
    public JokesController(ChuckNorrisJokesClient client) {
        this.client = client;
    }

    @GetMapping("random")
    public Map<String, String> getRandomJokes(){
        return Map.of("joke", client.getRandomJoke());
    }
}
