package com.soultech.productmanagement.repositories;

import com.soultech.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for interacting with the Product entity in the database.
 * * @author Solomon Demisse
 *  * @version 1.0
 *  * @since 2025-03-20
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
