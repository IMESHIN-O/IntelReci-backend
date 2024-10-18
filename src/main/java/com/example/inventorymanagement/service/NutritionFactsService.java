package com.example.inventorymanagement.service;

import com.example.inventorymanagement.repository.NutritionFactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionFactsService {

    @Autowired
    private NutritionFactsRepository nutritionFactsRepository;

    // 从数据库中获取所有食物名称
    public List<String> getAllFoodNames() {
        return nutritionFactsRepository.findAllFoodNames();
    }
}