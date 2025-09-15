package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.CheckoutRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;

public interface CheckOutService {
    OrderVTO checkOut( CheckoutRequestDTO value);
}
