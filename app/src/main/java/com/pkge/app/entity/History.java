package com.pkge.app.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "action_type")
    private String actionType;
    private int quantity;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "added_by_name")
    private String addedByName;
}
