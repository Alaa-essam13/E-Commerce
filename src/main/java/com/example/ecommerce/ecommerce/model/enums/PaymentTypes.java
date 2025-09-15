package com.example.ecommerce.ecommerce.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentTypes {
    MASTERCARD(1),
    VISA(2),
    PAYPAL(3);

    private final Integer id;
}
