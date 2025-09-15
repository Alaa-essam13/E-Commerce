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
@Table(name = "ec-user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;

    @Column(name = "first_name")
    @Basic
    private String firstName;

    @Column(name = "last_name")
    @Basic
    private String lastName;

    @Column(name = "email")
    @Basic
    private String email;

    @Column(name="mobile_number")
    @Basic
    private String mobileNumber;

    @Column(name = "password")
    @Basic
    private String password;

    @Column(name="status_id")
    @Basic
    private Integer statusId;

    @Column(name = "created_on")
    @Basic
    private LocalDateTime createdOn;

}
