package com.meli.spring3.starwars.controllers;

import com.meli.spring3.starwars.model.FilterStarWars;
import com.meli.spring3.starwars.services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @PostMapping
    public List<String> getCharactersWith(@RequestBody String filter){
        return starWarsService.getCharacters(filter);
    }

}
