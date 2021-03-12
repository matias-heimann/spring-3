package com.meli.spring3.starwars.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring3.food_exercise.model.IngredientDAO;
import com.meli.spring3.starwars.model.CharacterDAO;
import com.meli.spring3.starwars.repositories.StarWarsRepository;
import com.meli.spring3.starwars.services.impl.StarWarsServiceImpl;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    private List<CharacterDAO> characters;

    public StarWarsRepositoryImpl() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.characters = objectMapper.readValue(new File("src/main/resources/static/starwars.json"), new TypeReference<List<CharacterDAO>>(){});
    }

    @Override
    public List<CharacterDAO> getCharacterIfContainsQuery(String query) {
        return this.characters.stream()
                .filter(c -> c.getName().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }
}
