package com.meli.spring3.food_exercise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FoodPlate {

    @Getter @Setter
    private List<Ingredient> ingredients;
    @Getter @Setter
    private String name;

    public FoodPlate(List<Ingredient> ingredients, String name) {
        this.ingredients = ingredients;
        this.name = name;
    }


}
