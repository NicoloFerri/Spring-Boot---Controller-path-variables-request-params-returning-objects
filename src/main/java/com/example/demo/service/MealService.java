package com.example.demo.service;

import com.example.demo.entity.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MealService {
    private List<Meal> meals = new ArrayList<>();

    public List<Meal> selectAll(){
        return meals;
    }

    public boolean addMeal(Meal mealDaAggiungere){
        return meals.add(mealDaAggiungere);
    }

    public Optional<Meal> findByName (String name){
        Optional<Meal> opt = Optional.empty();
        for (Meal meal : meals) {
            if(meal.getName().equals(name)){
               return Optional.of(meal);
            }
        }
        return opt;
    }

    public Optional<Meal> findByDescription (String description){
        Optional<Meal> opt = Optional.empty();
        for (Meal meal : meals) {
            if(meal.getDescription().equals(description)){
                return Optional.of(meal);
            }
        }
        return opt;
    }

    public Optional<Meal> findByPriceRange (Double min, Double max){
        Optional<Meal> opt = Optional.empty();
        for (Meal meal : meals) {
            if(meal.getPrice()>min && meal.getPrice()<max){
                return Optional.of(meal);
            }
        }
        return opt;
    }

}
