package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.Inventory;
import com.example.inventorymanagement.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory addItem(Inventory item) {
        return inventoryRepository.save(item);
    }

    public List<Inventory> getAllItemsByUserId(Long userId) {
        return inventoryRepository.findByUserId(userId);
    }

    public Optional<Inventory> findById(Long itemId) {
        return inventoryRepository.findById(itemId);
    }

    public Inventory updateItem(Inventory item) {
        return inventoryRepository.save(item);
    }

    public void deleteItem(Long itemId) {
        inventoryRepository.deleteById(itemId);
    }

    public Optional<Inventory> findByUserIdAndItemName(Long userId, String itemName) {
        return Optional.ofNullable(inventoryRepository.findByUserIdAndItemName(userId, itemName));
    }
    public List<String> getAllItemNames() {
        return inventoryRepository.findAllItemNames();
    }

    // 更新库存项的数量
    public Inventory updateQuantity(Long id, double newQuantity) {
        Optional<Inventory> inventoryOpt = inventoryRepository.findById(id);
        if (inventoryOpt.isPresent()) {
            Inventory inventory = inventoryOpt.get();
            inventory.setQuantity((float)newQuantity);  // 更新数量
            return inventoryRepository.save(inventory); // 保存更新后的库存项
        } else {
            throw new RuntimeException("Item not found");
        }
    }
}
