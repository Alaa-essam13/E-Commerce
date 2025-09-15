package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;

    @Column(name = "orderDate")
    @Basic
    private LocalDateTime orderDate;

    @Column(name = "status")
    @Basic
    private String status;

    @Column(name = "totalAmount")
    @Basic
    private Double totalAmount;

    @Column(name = "created_at")
    @Basic
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @Basic
    private LocalDateTime updatedAt;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "user_id",insertable = false)
    private User user;



}
