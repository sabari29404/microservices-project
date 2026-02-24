package com.example.products_service.service;

import com.example.products_service.entity.ProductEntity;
import com.example.products_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public ProductEntity createProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getProducts(){
        return productRepository.findAll();
    }

    public ProductEntity getProductById(long id){
        return productRepository.findById(id).orElse(null);
    }
}
