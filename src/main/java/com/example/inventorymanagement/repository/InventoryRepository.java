package com.example.inventorymanagement.repository;

import com.example.inventorymanagement.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByUserId(Long userId);
    Inventory findByUserIdAndItemName(Long userId, String itemName);
    @Query("SELECT DISTINCT i.itemName FROM Inventory i")
    List<String> findAllItemNames();
}