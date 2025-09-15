package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-shipping")
public class Shipping {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;

    @Column(name = "address")
    @Basic
    private String address;

    @Column(name = "city")
    @Basic
    private String city;

    @Column(name = "postalCode")
    @Basic
    private String postalCode;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "order_id", insertable = false)
    private Order order;

}
