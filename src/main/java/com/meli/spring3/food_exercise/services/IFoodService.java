package com.meli.spring3.food_exercise.services;

import com.meli.spring3.food_exercise.model.FoodPlate;
import com.meli.spring3.food_exercise.model.dto.ErrorDTO;
import com.meli.spring3.food_exercise.model.dto.FoodPlateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFoodService {

    public ResponseEntity<FoodPlateDTO> getPlateInfo(FoodPlate foodPlate);
    public ResponseEntity<List<FoodPlateDTO>> getPlateInfo(List<FoodPlate> foodPlates);

}
