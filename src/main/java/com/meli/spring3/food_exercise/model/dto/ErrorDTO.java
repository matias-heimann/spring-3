package com.meli.spring3.food_exercise.model.dto;

import lombok.Getter;
import lombok.Setter;

public class ErrorDTO {

    @Getter @Setter
    private String error;

    public ErrorDTO(String error){
        this.error = error;
    }
}
