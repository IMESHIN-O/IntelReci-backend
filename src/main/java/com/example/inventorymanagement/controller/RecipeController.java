package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Recipe;
import com.example.inventorymanagement.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipesByUserId(@RequestParam Long userId) {
        List<Recipe> recipes = recipeService.getAllRecipesByUserId(userId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long recipeId) {
        Optional<Recipe> recipe = recipeService.findById(recipeId);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}/{recipeName}")
    public ResponseEntity<Recipe> getRecipeByUserIdAndRecipeName(@PathVariable Long userId, @PathVariable String recipeName) {
        Optional<Recipe> recipe = recipeService.findByUserIdAndRecipeName(userId, recipeName);
        return recipe.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe);
        return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
