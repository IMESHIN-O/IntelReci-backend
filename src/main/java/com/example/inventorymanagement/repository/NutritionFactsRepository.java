package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.NutritionFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionFactsRepository extends JpaRepository<NutritionFact, String> {

    // 使用自定义查询从 nutrition_facts 表中获取所有 food_name
    @Query("SELECT n.foodName FROM NutritionFact n")
    List<String> findAllFoodNames();
}
