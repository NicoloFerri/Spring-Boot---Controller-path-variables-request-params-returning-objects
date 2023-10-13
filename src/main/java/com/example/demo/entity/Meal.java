package com.example.demo.entity;

public class Meal {
    private Long id;
    private String name;
    private String description;
    private Integer calories;
    private Double price;

    public Meal(Long id, String name, String description, Integer calories, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
