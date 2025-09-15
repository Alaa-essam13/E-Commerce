package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.service.CheckOutService;
import com.example.ecommerce.ecommerce.model.dto.CheckoutRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckOutServiceImpl implements CheckOutService {
    @Override
    public OrderVTO checkOut(CheckoutRequestDTO value) {
        return null;
    }
}
