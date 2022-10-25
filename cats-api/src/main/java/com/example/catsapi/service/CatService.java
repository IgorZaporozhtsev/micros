package com.example.catsapi.service;

import com.example.catsapi.dto.CatDto;
import com.example.catsapi.entity.Cat;
import com.example.catsapi.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CatService {

    @Autowired
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public Cat save(CatDto dto){


        //using chain pattern
        // look at chain-pattern brunch
        // lombok @Accessors(chain = true)

        Cat newCat = new Cat()
                .setName(dto.getName())
                .setBirthDay(dto.getBirthDay())
                .setId(UUID.randomUUID().toString())
                .setCreateAt(LocalDateTime.now());


        return catRepository.save(newCat);
    }

    //in real project when we retrieve a lot of data we should use Pageable and Filter

    public Iterable<Cat> getAll(){
        return catRepository.findAll();
    }

}
