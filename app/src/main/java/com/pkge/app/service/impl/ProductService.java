package com.pkge.app.service.impl;

import com.pkge.app.DTO.ProductDTO;
import com.pkge.app.controller.SecurityContextController;
import com.pkge.app.entity.History;
import com.pkge.app.entity.Product;
import com.pkge.app.entity.User;
import com.pkge.app.repository.HistoryRepository;
import com.pkge.app.repository.ProductRepository;
import com.pkge.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository, HistoryRepository historyRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
    }

    public List<Product> getAllProducts() {
        SecurityContextController securityController = new SecurityContextController();
        String userName = securityController.getSecurityContextData();

        User user = userRepository.findByUsername(userName);

        if (user.getRole().equals("USER")) {
            return productRepository.findByStatus("ACTIVO");
        }

        return productRepository.findAll();
    }

    public Product addProduct(ProductDTO productDTO) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);

        SecurityContextController securityController = new SecurityContextController();
        String userName = securityController.getSecurityContextData();

        User user = userRepository.findByUsername(userName);

        if (user == null || user.getName().isEmpty() || productDTO.getName().isEmpty()) {
            throw new Exception("No se puede registrar el producto");
        }

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDeletedAt(productDTO.getDeletedAt());
        product.setUpdatedAt(formattedDate);
        product.setCreatedAt(formattedDate);
        product.setStatus(productDTO.getStatus());
        product.setAddedByName(user.getName());

        Product addedProduct = productRepository.save(product);

        History history = new History();

        history.setProductId(addedProduct.getId());
        history.setQuantity(addedProduct.getQuantity());
        history.setActionType("ENTRADA");
        history.setCreatedAt(formattedDate);
        history.setAddedByName(user.getName());

        historyRepository.save(history);

        return addedProduct;
    }

    public int updateStatusProduct(int id, String status) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String deletedDate = now.format(formatter);
        String updatedDate = now.format(formatter);

        if (status.equals("ACTIVO")) {
            deletedDate = null;
        }

        return productRepository.statusUpdateProduct(id, status, deletedDate, updatedDate);
    }

    public int updateQuantityProduct(int id, int quantity, String action) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String updatedDate = now.format(formatter);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        SecurityContextController securityController = new SecurityContextController();
        String userName = securityController.getSecurityContextData();

        User user = userRepository.findByUsername(userName);

        if (action.equals("ENTRADA")) {
            if (product.getQuantity() < quantity && quantity > 0) {
                History history = new History();

                history.setProductId(id);
                history.setQuantity(quantity - product.getQuantity());
                history.setActionType(action);
                history.setCreatedAt(updatedDate);
                history.setAddedByName(user.getName());

                historyRepository.save(history);

                return productRepository.quantityUpdateProduct(id, quantity, updatedDate);
            }

            if (product.getQuantity() < quantity && quantity == 0) {
                History history = new History();

                history.setProductId(id);
                history.setQuantity(quantity);
                history.setActionType(action);
                history.setCreatedAt(updatedDate);
                history.setAddedByName(user.getName());

                historyRepository.save(history);

                return productRepository.quantityUpdateProduct(id, quantity, updatedDate);
            }

        } else {
            if (product.getQuantity() > quantity && quantity > 0) {
                History history = new History();

                history.setProductId(id);
                history.setQuantity(product.getQuantity() - quantity);
                history.setActionType(action);
                history.setCreatedAt(updatedDate);
                history.setAddedByName(user.getName());

                historyRepository.save(history);

                return productRepository.quantityUpdateProduct(id, quantity, updatedDate);
            }

            if (product.getQuantity() > quantity && quantity == 0) {
                History history = new History();

                history.setProductId(id);
                history.setQuantity(product.getQuantity());
                history.setActionType(action);
                history.setCreatedAt(updatedDate);
                history.setAddedByName(user.getName());

                historyRepository.save(history);

                return productRepository.quantityUpdateProduct(id, quantity, updatedDate);
            }

        }

        return productRepository.quantityUpdateProduct(id, quantity, updatedDate);
    }
}
