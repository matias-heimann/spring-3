package com.meli.spring3.starwars.services.impl;

import com.meli.spring3.starwars.model.CharacterDAO;
import com.meli.spring3.starwars.model.FilterStarWars;
import com.meli.spring3.starwars.repositories.StarWarsRepository;
import com.meli.spring3.starwars.services.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    private StarWarsRepository starWarsRepository;

    @Override
    public List<String> getCharacters(String query) {
        List<CharacterDAO> characters = this.starWarsRepository.getCharacterIfContainsQuery(query);
        return characters.stream().map(c -> c.getName()).collect(Collectors.toList());
    }
}
