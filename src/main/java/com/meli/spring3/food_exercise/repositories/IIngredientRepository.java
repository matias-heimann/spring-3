package com.meli.spring3.food_exercise.repositories;

import com.meli.spring3.food_exercise.model.Ingredient;
import com.meli.spring3.food_exercise.model.IngredientDAO;

import java.util.List;

public interface IIngredientRepository {

    public List<IngredientDAO> getIngredients(List<Ingredient> ingredientList);

}
