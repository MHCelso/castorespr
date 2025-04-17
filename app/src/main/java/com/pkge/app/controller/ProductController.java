package com.pkge.app.controller;


import com.pkge.app.entity.Product;
import com.pkge.app.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("products")
    public ResponseEntity<Object> getProducts() {
        try {
            List<Product> products = productService.getAllProducts();

            return ResponseEntity.ok(products);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al obtener los productos: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
