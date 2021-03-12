package com.meli.spring3.food_exercise.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.spring3.food_exercise.model.Ingredient;
import com.meli.spring3.food_exercise.model.IngredientDAO;
import com.meli.spring3.food_exercise.repositories.IIngredientRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository implements IIngredientRepository {


    private List<IngredientDAO> ingredients;

    public IngredientRepository() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.ingredients = objectMapper.readValue(new File("src/main/resources/static/food.json"), new TypeReference<List<IngredientDAO>>(){});
    }

    @Override
    public List<IngredientDAO> getIngredients(List<Ingredient> ingredientList) {
        List<IngredientDAO> ret = this.ingredients.stream().filter(i1 ->
                ingredientList.stream().anyMatch(i2 -> i2.getName().equals(i1.getName()))
        ).collect(Collectors.toList());
        return (ret.size() == ingredientList.size()) ? ret : null;
    }


}
