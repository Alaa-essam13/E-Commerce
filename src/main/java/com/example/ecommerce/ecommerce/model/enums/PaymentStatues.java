package com.example.ecommerce.ecommerce.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatues {
    PENDING(1),
    SUCCESS(2),
    FAILED(3);

    private final Integer id;
}
