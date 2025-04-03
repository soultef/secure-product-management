package com.soultech.productmanagement.services;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing products in the system.
 * <p>
 * This class provides business logic for handling product-related operations,
 * including retrieving, adding, updating, and deleting products. It acts as
 * an intermediary between the controller and the repository layer.
 * </p>
 *
 * <p>
 * Features:
 * - Retrieve all products from the database.
 * - Add a new product.
 * - Fetch a product by its ID.
 * - Update an existing product.
 * - Delete a product by its ID.
 * </p>
 *
 * <p>
 * This class follows best practices by using constructor-based dependency injection
 * and ensuring proper interaction with the database layer via {@code ProductRepository}.
 * </p>
 *
 * @author Solomon Demisse
 * @version 1.0
 * @since 2025-03-24
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
    * Retrieves all products from the database.
    */
    public List<Product> getAllProducts()
    {
       return productRepository.findAll();
    }

    /**
     * add a product into a database
     */
    public void addProduct(Product product)
    {

        productRepository.save(product);
    }

    /**
     * Fetches a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product if found, otherwise null.
     */
    public Product getProductById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    /**
     * Updates an existing product.
     *
     * @param id             The ID of the product to update.
     * @param newProductData The updated product data.
     */
    public void updateProduct(Long id, Product newProductData) {
        productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(newProductData.getName());
                    existingProduct.setPrice(newProductData.getPrice());
                    existingProduct.setDescription(newProductData.getDescription());
                    return productRepository.save(existingProduct); // Ensures UPDATE, not INSERT
                })
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    /**
     * Deletes a product by its ID.
     * @param id The ID of the product to be deleted.
     */
    public void deleteProduct(long id)
    {
        productRepository.deleteById(id);
    }
}
