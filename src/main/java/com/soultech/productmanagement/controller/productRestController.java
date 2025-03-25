package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products/api")
public class productRestController {
    private ProductService productService;

    @Autowired
    public productRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/api")
    public List<Product> getAllProduct()
    {
        return null;
    }

    @PostMapping("/products/api/")
    public Product saveAProduct(@RequestBody Product product)
    {
        return null;
    }

    @GetMapping("/products/api/{id}")
    public Product getProductById(long id)
    {
        return null;
    }

    @DeleteMapping("/products/api/{id}")
    public void deleteAProduct(int id)
    {

    }

    @PutMapping("/products/api/{id}")
    public void updateProduct(Product product)
    {
    
    }
}
