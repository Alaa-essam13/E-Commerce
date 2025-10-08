package com.example.ecommerce.ecommerce.lib.error;

import org.springframework.http.HttpStatus;

public enum Error {

    USER_NOT_FOUND("Wrong Email Or Password", HttpStatus.NOT_FOUND),
    INVALID_CREDENTIAL("Invalid Email Or Password", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXIST("Email Already Exist", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND("Product not found", HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND("Order not found", HttpStatus.NOT_FOUND),
    ORDER_ITEM_NOT_FOUND("OrderItem not found", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_FOUND("Category not found", HttpStatus.NOT_FOUND),
    CART_NOT_FOUND("Cart not found", HttpStatus.NOT_FOUND),
    CART_ITEM_NOT_FOUND("Cart Item not found", HttpStatus.NOT_FOUND),
    INVALID_REQUEST("Invalid request data", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("You are not authorized", HttpStatus.UNAUTHORIZED),
    INTERNAL_ERROR("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus status;

    Error(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
