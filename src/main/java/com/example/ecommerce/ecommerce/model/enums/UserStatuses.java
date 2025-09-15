package com.example.ecommerce.ecommerce.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatuses {
    ACTIVE(1),
    DELETED(2);

    private final Integer id;

}
