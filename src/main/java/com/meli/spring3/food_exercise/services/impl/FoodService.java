package com.meli.spring3.food_exercise.services.impl;

import com.meli.spring3.food_exercise.exceptions.IngredientNotFoundException;
import com.meli.spring3.food_exercise.model.FoodPlate;
import com.meli.spring3.food_exercise.model.Ingredient;
import com.meli.spring3.food_exercise.model.IngredientDAO;
import com.meli.spring3.food_exercise.model.dto.FoodPlateDTO;
import com.meli.spring3.food_exercise.model.dto.IngredientDTO;
import com.meli.spring3.food_exercise.repositories.IIngredientRepository;
import com.meli.spring3.food_exercise.services.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class FoodService implements IFoodService {

    @Autowired
    private IIngredientRepository ingredientRepository;


    @Override
    public ResponseEntity<List<FoodPlateDTO>> getPlateInfo(List<FoodPlate> foodPlates) {
        List<FoodPlateDTO> foodPlateDTOS = new LinkedList<>();
        for(FoodPlate foodPlate: foodPlates){
            if(foodPlate == null || foodPlate.getIngredients() == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            List<IngredientDAO> ingredientDAOS = ingredientRepository.getIngredients(foodPlate.getIngredients());
            if(ingredientDAOS == null){
                throw new IngredientNotFoundException("Ingredient not found");
            }

            Double totalCalories = this.getTotalCalories(foodPlate, ingredientDAOS);
            if(totalCalories == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            List<IngredientDTO> ingredientDTOS = this.getIngredientList(foodPlate, ingredientDAOS);

            foodPlateDTOS.add(new FoodPlateDTO(foodPlate.getName(), totalCalories, ingredientDTOS, getIngredientWithMostCalories(foodPlate, ingredientDAOS)));
        }
        return new ResponseEntity<>(foodPlateDTOS, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<FoodPlateDTO> getPlateInfo(FoodPlate foodPlate) {
        if(foodPlate == null || foodPlate.getIngredients() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<IngredientDAO> ingredientDAOS = ingredientRepository.getIngredients(foodPlate.getIngredients());
        if(ingredientDAOS == null){
            throw new IngredientNotFoundException("Ingredient not found");
        }

        Double totalCalories = this.getTotalCalories(foodPlate, ingredientDAOS);
        if(totalCalories == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<IngredientDTO> ingredientDTOS = this.getIngredientList(foodPlate, ingredientDAOS);


        return new ResponseEntity<>(new FoodPlateDTO(foodPlate.getName(), totalCalories, ingredientDTOS, getIngredientWithMostCalories(foodPlate, ingredientDAOS)),HttpStatus.OK);
    }

    private Double getTotalCalories(FoodPlate foodPlate, List<IngredientDAO> ingredients){
        Double totalCalories = 0.0;
        for(Ingredient ingredient: foodPlate.getIngredients()){
            if(ingredient.getGrams() == null || ingredient.getName() == null){
                return null;
            }
            Integer calories = ingredients.stream().filter(i -> i.getName().equals(ingredient.getName())).findFirst().get().getCalories();
            totalCalories += ingredient.getGrams() * calories / 100.0;
        }
        return totalCalories;
    }

    private List<IngredientDTO> getIngredientList(FoodPlate foodPlate, List<IngredientDAO> ingredients){
        List<IngredientDTO> ingredientDTOS = new LinkedList<>();
        for(Ingredient ingredient: foodPlate.getIngredients()){
            Integer calories = ingredients.stream().filter(i -> i.getName().equals(ingredient.getName())).findFirst().get().getCalories();
            Double caloriesDto = ingredient.getGrams() * calories / 100.0;
            ingredientDTOS.add(new IngredientDTO(ingredient.getName(), caloriesDto));
        }
        return ingredientDTOS;
    }

    private IngredientDTO getIngredientWithMostCalories(FoodPlate foodPlate, List<IngredientDAO> ingredients){
        Double maxCalories = 0.0;
        IngredientDTO maxCaloriesIngredient = null;
        for(Ingredient ingredient: foodPlate.getIngredients()){
            Integer calories = ingredients.stream().filter(i -> i.getName().equals(ingredient.getName())).findFirst().get().getCalories();
            Double caloriesDto = ingredient.getGrams() * calories / 100.0;
            if(caloriesDto > maxCalories){
                maxCalories = caloriesDto;
                maxCaloriesIngredient = new IngredientDTO(ingredient.getName(), caloriesDto);
            }
        }
        return maxCaloriesIngredient;
    }

}
