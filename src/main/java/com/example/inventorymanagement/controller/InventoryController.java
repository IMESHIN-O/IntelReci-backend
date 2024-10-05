package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.model.Inventory;
import com.example.inventorymanagement.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> addItem(@RequestBody Inventory inventory) {
        Inventory newItem = inventoryService.addItem(inventory);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllItemsByUserId(@RequestParam Long userId) {
        List<Inventory> items = inventoryService.getAllItemsByUserId(userId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Inventory> getItemById(@PathVariable Long itemId) {
        Optional<Inventory> item = inventoryService.findById(itemId);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{userId}/{itemName}")
    public ResponseEntity<Inventory> getItemByUserIdAndItemName(@PathVariable Long userId, @PathVariable String itemName) {
        Optional<Inventory> item = inventoryService.findByUserIdAndItemName(userId, itemName);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<Inventory> updateItem(@RequestBody Inventory inventory) {
        Inventory updatedItem = inventoryService.updateItem(inventory);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        inventoryService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}