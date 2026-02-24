package com.example.order_service.controller;

import com.example.order_service.dto.OrderResponseDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/createOrder")
    public Mono<ResponseEntity<OrderResponseDto>> createOrder(@RequestBody OrderEntity orderEntity){
        return orderService.createOrder(orderEntity);
    }

    @GetMapping("/getOrders")
    public List<OrderEntity> getOrders(){
        return orderService.getOrders();
    }

}
