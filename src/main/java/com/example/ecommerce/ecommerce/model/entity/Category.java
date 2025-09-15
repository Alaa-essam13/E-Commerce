package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Integer id;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "created_at")
    @Basic
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @Basic
    private LocalDateTime updatedAt;


}
