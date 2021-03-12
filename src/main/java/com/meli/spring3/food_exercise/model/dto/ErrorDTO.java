package com.meli.spring3.food_exercise.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ErrorDTO {

    private String message;

    public ErrorDTO(String message) {
        this.message = message;
    }
}
