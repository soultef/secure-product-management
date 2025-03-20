package com.soultech.productmanagement.services;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing product operations.
 * This class provides CRUD operations for Product entities,
 * interacting with the ProductRepository.
 */
@Service
public class ProductService {
    private ProductRepository productRepository;

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
     * @param id The ID of the product to update.
     * @param updatedProduct The updated product data.
     */
    public void updateProduct(long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            productRepository.save(updatedProduct);
        }
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
