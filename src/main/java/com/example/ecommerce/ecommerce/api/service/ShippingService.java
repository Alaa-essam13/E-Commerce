package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.ShippingCostRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.ShippingCostResponseVTO;

public interface ShippingService {
    ShippingCostResponseVTO createShipping(ShippingCostRequestDTO shippingCostRequestDTO);
}
