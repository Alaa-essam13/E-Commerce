package com.example.ecommerce.ecommerce.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long user_id;
}
