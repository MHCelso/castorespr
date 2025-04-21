package com.pkge.app.repository;

import com.pkge.app.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    Optional<Product> findById(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.status = :status, deletedAt = :dDate, updatedAt = :uDate WHERE p.id = :id")
    int statusUpdateProduct(@Param("id") int id, @Param("status") String status, @Param("dDate") String deletedDate, @Param("uDate") String updatedDate);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.quantity= :quantity, updatedAt = :uDate WHERE p.id = :id")
    int quantityUpdateProduct(@Param("id") int id, @Param("quantity") int quantity, @Param("uDate") String updatedDate);
}
