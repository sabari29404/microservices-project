package com.example.order_service.dto;

import lombok.Data;

@Data
public class OrderResponseDto {

    private long orderId;
    private long productId;
    private int quantity;
    private double totalPrice;
    private String productName;
    private double productPrice;

}
