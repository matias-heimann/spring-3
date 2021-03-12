package com.meli.spring3.food_exercise.model.dto;

import lombok.Getter;

import java.util.List;

public class FoodPlateDTO {

    @Getter
    private String name;
    @Getter
    private Double totalCalories;
    @Getter
    private List<IngredientDTO> ingredients;
    @Getter
    private IngredientDTO maxCaloriesIngredient;

    public FoodPlateDTO(String name, Double totalCalories, List<IngredientDTO> ingredients, IngredientDTO maxCaloriesIngredient) {
        this.name = name;
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.maxCaloriesIngredient = maxCaloriesIngredient;
    }
}
