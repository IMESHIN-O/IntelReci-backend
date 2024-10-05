package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByUserId(Long userId);
    Recipe findByUserIdAndRecipeName(Long userId, String recipeName);
}