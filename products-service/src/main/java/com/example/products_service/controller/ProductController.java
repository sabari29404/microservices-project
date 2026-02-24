package com.example.products_service.controller;

import com.example.products_service.entity.ProductEntity;
import com.example.products_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity productEntity){
        return ResponseEntity.ok(productService.createProduct(productEntity));
    }

    @GetMapping("/getProducts")
    public List<ProductEntity> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id){
        ProductEntity productById= productService.getProductById(id);
        if(productById==null)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Product not found with given ID");
        return ResponseEntity.ok(productById);
    }

}
