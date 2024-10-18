package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Inventory;
import com.example.inventorymanagement.model.ShoppingList;
import com.example.inventorymanagement.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shopping-list")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;

    @PostMapping("/create")
    public ResponseEntity<ShoppingList> createShoppingListItem(@RequestBody ShoppingList shoppingList) {
        ShoppingList createdItem = shoppingListService.addItem(shoppingList);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShoppingList>> getAllItemsByUserId(@RequestParam Long userId) {
        List<ShoppingList> items = shoppingListService.getAllItemsByUserId(userId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ShoppingList> getItemById(@PathVariable Long itemId) {
        Optional<ShoppingList> item = shoppingListService.findById(itemId);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}/{itemName}")
    public ResponseEntity<ShoppingList> getItemByUserIdAndItemName(@PathVariable Long userId, @PathVariable String itemName) {
        Optional<ShoppingList> item = shoppingListService.findByUserIdAndItemName(userId, itemName);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<ShoppingList> updateItem(@PathVariable Long itemId, @RequestBody ShoppingList updatedShoppingList) {
        ShoppingList updatedItem = shoppingListService.updateItem(itemId,updatedShoppingList.getQuantity());
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        shoppingListService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteAllItemsByUserId(@PathVariable Long userId) {
        shoppingListService.deleteAllItemsByUserId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
