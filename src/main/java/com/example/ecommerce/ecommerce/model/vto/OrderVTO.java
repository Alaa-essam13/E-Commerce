package com.example.ecommerce.ecommerce.model.vto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderVTO {
    private Long id;
    private List<OrderItemVTO> orderItems;
    private Double total;
    private String status;
}
