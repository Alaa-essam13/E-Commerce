package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.service.ShippingService;
import com.example.ecommerce.ecommerce.model.dto.ShippingCostRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.ShippingCostResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShippingServiceImpl implements ShippingService {
    @Override
    public ShippingCostResponseVTO createShipping(ShippingCostRequestDTO shippingCostRequestDTO) {
        return null;
    }
}
