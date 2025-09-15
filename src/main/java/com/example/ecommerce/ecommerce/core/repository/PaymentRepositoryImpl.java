package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.PaymentRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.PaymentJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final PaymentJPARepository paymentJPARepository;
}
