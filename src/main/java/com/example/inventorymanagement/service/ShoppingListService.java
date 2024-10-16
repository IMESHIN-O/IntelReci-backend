package com.example.inventorymanagement.service;

import com.example.inventorymanagement.model.Inventory;
import com.example.inventorymanagement.model.ShoppingList;
import com.example.inventorymanagement.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingList addItem(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public List<ShoppingList> getAllItemsByUserId(Long userId) {
        return shoppingListRepository.findByUserId(userId);
    }

    public Optional<ShoppingList> findById(Long itemId) {
        return shoppingListRepository.findById(itemId);
    }

    public Optional<ShoppingList> findByUserIdAndItemName(Long userId, String itemName) {
        return Optional.ofNullable(shoppingListRepository.findByUserIdAndItemName(userId, itemName));
    }

    public ShoppingList updateItem(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }
    public ShoppingList updateItem(Long itemId,double newQuantity) {
        Optional<ShoppingList> shoppingListOpt = shoppingListRepository.findById(itemId);
        if (shoppingListOpt.isPresent()) {
            ShoppingList shoppingList = shoppingListOpt.get();
            shoppingList.setQuantity((int)newQuantity);  // 更新数量
            return shoppingListRepository.save(shoppingList); // 保存更新后的库存项
        } else {
            throw new RuntimeException("Item not found");
        }
    }

    public void deleteItem(Long itemId) {
        shoppingListRepository.deleteById(itemId);
    }

    public void deleteAllItemsByUserId(Long userId) {
        List<ShoppingList> items = shoppingListRepository.findByUserId(userId);
        shoppingListRepository.deleteAll(items);
    }
}