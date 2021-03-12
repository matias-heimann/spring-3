package com.meli.spring3.food_exercise.model;

import lombok.Getter;
import lombok.Setter;


public class Ingredient {

    @Setter @Getter
    private String name;
    @Setter @Getter
    private Integer grams;

    public Ingredient(String name, Integer grams) {
        this.name = name;
        this.grams = grams;
    }
}
