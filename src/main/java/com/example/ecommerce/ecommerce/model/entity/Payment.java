package com.example.ecommerce.ecommerce.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ec-payment")
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private Long id;

    @Column(name = "amount")
    @Basic
    private Double amount;

    @Column(name = "paymentMethod")
    @Basic
    private String paymentMethod;

    @Column(name = "status")
    @Basic
    private String status;

    @Column(name = "paymentDate")
    @Basic
    private LocalDateTime dateTime;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "order_id", insertable = false)
    private Order order;

}
