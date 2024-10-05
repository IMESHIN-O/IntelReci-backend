package com.example.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shopping_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // 关联用户
}