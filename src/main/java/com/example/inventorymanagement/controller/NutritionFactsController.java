package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.service.NutritionFactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/api/nutrition-facts")
@CrossOrigin(origins = "http://localhost:3000")
public class NutritionFactsController {

    @Autowired
    private NutritionFactsService nutritionFactsService;

    // 获取所有的食物名称
    @GetMapping("/names")
    public List<String> getAllFoodNames() {
        return nutritionFactsService.getAllFoodNames();
    }
}
