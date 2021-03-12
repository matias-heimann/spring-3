package com.meli.spring3.starwars.services;

import com.meli.spring3.starwars.model.FilterStarWars;

import java.util.List;

public interface StarWarsService {

    public List<String> getCharacters(String query);

}
