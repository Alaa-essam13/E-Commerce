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
@Table(name = "ec-role")
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Integer id;

    @Column(name="title_en")
    @Basic
    private String titleEn;

    @Column(name="title_ar")
    @Basic
    private String titleAr;

    @Column(name = "created_at")
    @Basic
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @Basic
    private LocalDateTime updatedAt;
}
