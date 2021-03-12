package com.meli.spring3.food_exercise.exceptions;

public class IngredientNotFoundException extends RuntimeException{

    public IngredientNotFoundException(String message){
        super(message);
    }

}
