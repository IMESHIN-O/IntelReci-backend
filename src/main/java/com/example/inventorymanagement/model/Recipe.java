package com.example.inventorymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipeName;
    private String description;

    @Lob
    private String ingredients;  // 以 JSON 格式存储食材信息

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // 关联用户
}