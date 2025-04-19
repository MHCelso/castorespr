package com.pkge.app.controller;


import com.pkge.app.DTO.ProductDTO;
import com.pkge.app.entity.Product;
import com.pkge.app.service.impl.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/")
@RequiredArgsConstructor
public class APIProductController {
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

    @PostMapping("register")
    @Builder
    public ResponseEntity<Object> productRegister(HttpServletRequest request) {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = now.format(formatter);

            ProductDTO productDTO = new ProductDTO.Builder()
                    .name(request.getParameter("name"))
                    .price(Double.parseDouble(request.getParameter("price")))
                    .quantity(Integer.parseInt(request.getParameter("quantity")))
                    .createdAt(formattedDate)
                    .updatedAt(formattedDate)
                    .deletedAt(null)
                    .status(request.getParameter("status"))
                    .addedByName("me")
                    .build();

            Product product = productService.addProduct(productDTO);

            return ResponseEntity.ok(product);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();

            error.put("message", "Error al registrar: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }
}
