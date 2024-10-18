package com.example.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nutrition_facts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NutritionFact {

    @Id
    @Column(name = "food_name")
    private String foodName;

    @Column(name = "calories")
    private int calories;

    @Column(name = "sugar")
    private float sugar;

    @Column(name = "protein")
    private float protein;

    @Column(name = "fat")
    private float fat;

    @Column(name = "fiber")
    private float fiber;

    @Column(name = "sodium")
    private float sodium;

    @Column(name = "potassium")
    private float potassium;

    @Column(name = "calcium")
    private float calcium;

    @Column(name = "iron")
    private float iron;

    @Column(name = "vitamin_a")
    private float vitaminA;

    @Column(name = "vitamin_b1")
    private float vitaminB1;

    @Column(name = "vitamin_b2")
    private float vitaminB2;

    @Column(name = "vitamin_b3")
    private float vitaminB3;

    @Column(name = "vitamin_b5")
    private float vitaminB5;

    @Column(name = "vitamin_b6")
    private float vitaminB6;

    @Column(name = "vitamin_b7")
    private float vitaminB7;

    @Column(name = "vitamin_b9")
    private float vitaminB9;

    @Column(name = "vitamin_b12")
    private float vitaminB12;

    @Column(name = "vitamin_c")
    private float vitaminC;

    @Column(name = "vitamin_d")
    private float vitaminD;

    @Column(name = "vitamin_e")
    private float vitaminE;

    @Column(name = "vitamin_k")
    private float vitaminK;

}

