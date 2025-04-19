package com.pkge.app.service.impl;

import com.pkge.app.DTO.ProductDTO;
import com.pkge.app.entity.Product;
import com.pkge.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDeletedAt(productDTO.getDeletedAt());
        product.setUpdatedAt(productDTO.getUpdatedAt());
        product.setCreatedAt(productDTO.getCreatedAt());
        product.setStatus(productDTO.getStatus());
        product.setAddedByName(productDTO.getAddedByName());

        return productRepository.save(product);
    }
}
