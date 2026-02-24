package com.example.order_service.service;

import com.example.order_service.dto.OrderResponseDto;
import com.example.order_service.dto.ProductDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OrderService {

    private WebClient.Builder webClientBuilder;
    private OrderRepository orderRepository;

    OrderService(WebClient.Builder webClientBuilder, OrderRepository orderRepository){
        this.webClientBuilder=webClientBuilder;
        this.orderRepository=orderRepository;
    }

    public Mono<ResponseEntity<OrderResponseDto>> createOrder(OrderEntity orderEntity){

        return webClientBuilder.build().get()
                .uri("http://PRODUCTS-SERVICE/products/getProductById/"+orderEntity.getProductId())
                .retrieve().bodyToMono(ProductDto.class).map(productDto -> {

                    OrderResponseDto orderResponseDto=new OrderResponseDto();

                    orderResponseDto.setOrderId(orderEntity.getProductId());
                    orderResponseDto.setQuantity(orderEntity.getQuantity());
                    orderResponseDto.setProductName(productDto.getName());
                    orderResponseDto.setProductPrice(productDto.getPrice());
                    orderResponseDto.setTotalPrice(productDto.getPrice()*orderEntity.getQuantity());

                    orderRepository.save(orderEntity);
                    orderResponseDto.setOrderId(orderEntity.getId());
                    return ResponseEntity.ok(orderResponseDto);
                });

    }

    public List<OrderEntity> getOrders(){
        return orderRepository.findAll();
    }

}
