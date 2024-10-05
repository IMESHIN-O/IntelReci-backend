package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    List<ShoppingList> findByUserId(Long userId);
    ShoppingList findByUserIdAndItemName(Long userId, String itemName);
}
