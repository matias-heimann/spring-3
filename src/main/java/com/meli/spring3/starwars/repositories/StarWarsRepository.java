package com.meli.spring3.starwars.repositories;

import com.meli.spring3.starwars.model.CharacterDAO;

import java.util.List;

public interface StarWarsRepository {
    public List<CharacterDAO> getCharacterIfContainsQuery(String query);
}
