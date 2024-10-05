package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.Recipe;
import com.example.inventorymanagement.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipesByUserId(Long userId) {
        return recipeRepository.findByUserId(userId);
    }

    public Optional<Recipe> findById(Long recipeId) {
        return recipeRepository.findById(recipeId);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public Optional<Recipe> findByUserIdAndRecipeName(Long userId, String recipeName) {
        return Optional.ofNullable(recipeRepository.findByUserIdAndRecipeName(userId, recipeName));
    }
}
