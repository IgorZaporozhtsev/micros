package com.example.catsapi.controller;

import com.example.catsapi.dto.CatDto;
import com.example.catsapi.entity.Cat;
import com.example.catsapi.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
// @RequiredArgsConstructor //can use the annotation instead constructor injection
public class CatController {

    @Autowired
    private final CatService service;

    public CatController(CatService service){
        this.service = service;
    }

    @PostMapping
    public Cat save(@RequestBody CatDto cat) {
        return service.save(cat);
    }

    @GetMapping
    public Iterable<Cat> getAll(){
        return service.getAll();
    }
}
