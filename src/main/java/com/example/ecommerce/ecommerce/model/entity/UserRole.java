package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-user-role")
public class UserRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User scopeId;
}
