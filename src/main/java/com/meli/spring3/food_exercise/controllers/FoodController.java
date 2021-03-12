package com.meli.spring3.food_exercise.controllers;

import com.meli.spring3.food_exercise.exceptions.IngredientNotFoundException;
import com.meli.spring3.food_exercise.model.FoodPlate;
import com.meli.spring3.food_exercise.model.dto.ErrorDTO;
import com.meli.spring3.food_exercise.model.dto.FoodPlateDTO;
import com.meli.spring3.food_exercise.services.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @PostMapping
    public ResponseEntity<FoodPlateDTO> getFoodInfo(@RequestBody FoodPlate foodPlate){
        return this.foodService.getPlateInfo(foodPlate);
    }

    @PostMapping("/list")
    public ResponseEntity<List<FoodPlateDTO>> getFoodInfo(@RequestBody List<FoodPlate> foodPlate){
        return this.foodService.getPlateInfo(foodPlate);
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity<ErrorDTO> getError(IngredientNotFoundException exception){
        return new ResponseEntity<>(new ErrorDTO(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
