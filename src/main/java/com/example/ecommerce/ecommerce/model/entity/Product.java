package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;


    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "description")
    @Basic
    private String description;

    @Column(name = "price")
    @Basic
    private Double price;

    @Column(name="quantity")
    @Basic
    private Integer quantity;

    @Column(name = "created_at")
    @Basic
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @Basic
    private LocalDateTime updatedAt;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "category_id")
    private Category category;

}
