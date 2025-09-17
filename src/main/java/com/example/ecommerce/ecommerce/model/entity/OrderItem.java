package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-order_item")
public class OrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;

    @Column(name="quantity")
    @Basic
    private Integer quantity;

    @Column(name="priceAtPurchase")
    @Basic
    private Double priceAtPurchase;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "order_id")
    private Order order;
}
