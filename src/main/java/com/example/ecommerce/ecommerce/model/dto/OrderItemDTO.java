package com.example.ecommerce.ecommerce.model.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Integer quantity;
    private Double priceAtPurchase;
    private Long product_id;
}
