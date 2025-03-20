package com.soultech.productmanagement.services;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {}

    public List<Product> getAllProducts()
    {
        return null;
    }

    public void addProduct(Product product)
    {

    }
    public Product getProductById(long id)
    {
        return null;
    }

    public void updateProduct(long id, Product updatedProduct)
    {

    }
    public void deleteProduct(long id)
    {

    }
}
