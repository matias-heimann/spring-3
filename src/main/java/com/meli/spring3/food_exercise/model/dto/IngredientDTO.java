package com.meli.spring3.food_exercise.model.dto;

import lombok.Getter;

public class IngredientDTO {

    @Getter
    private String name;
    @Getter
    private Double calories;

    public IngredientDTO(String name, Double calories) {
        this.name = name;
        this.calories = calories;
    }
}
