package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing product-related operations.
 * <p>
 * This class handles HTTP requests related to product management, including
 * displaying a list of products, adding a new product, and updating existing products.
 * It interacts with {@link ProductService} to perform the required business logic.
 * </p>
 *
 * <p>
 * Endpoints:
 * - {@code GET /products} - Displays the list of products.
 * - {@code GET /products/add} - Displays the product addition form.
 * - {@code POST /products/add} - Handles the creation of a new product.
 * - {@code PUT /products/{id}/update} - Handles updating an existing product.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 * @since 2025
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * Constructor for {@code ProductController}.
     *
     * @param productService The service layer responsible for product operations.
     */
    public ProductController(ProductService productService)
    {

        this.productService = productService;
    }

    /**
     * Displays the list of products.
     *
     * @param model The model to store product data.
     * @return The view name for displaying products.
     */
    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product";
    }

    /**
     * Displays form to add a product.
     *
     * @param model The model to store a new product object.
     * @return The view name for the add product form.
     */
    @GetMapping("/add-a-product")
    public String showAddProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-a-product";
    }

    /**
     * Handles the addition of a new product.
     *
     * @param product The product to be added.
     * @return A redirect to the product list page.
     */
    @PostMapping("/add/{id}")
    public String addProduct(@PathVariable Long id, @ModelAttribute Product product) {
        if(id == 0 ) {
            productService.addProduct(product);
        }
        else {
            productService.updateProduct(id, product);
        }
        return "redirect:/products";

    }

    /**
     * Handles updating an existing product.
     *
     * @param id The ID of the product to be updated.
     * @param product The updated product data.
     * @return A redirect to the product list page.
     */
    @GetMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            productService.updateProduct(id, product);
            return ResponseEntity.ok("Product updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    /**
     * Displays the form for editing an existing product.
     *
     * @param id The ID of the product to be edited.
     * @param model The model to pass the product data to the view.
     * @return The name of the Thymeleaf template to display the edit form.
     */
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "add-a-product"; // Template for the edit form
    }

    /**
     * Handles deleting a product by its ID.
     *
     * @param id The ID of the product to be deleted.
     * @return A redirect to the product list page after deletion.
     */
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    /**
     * Searches products by its name.
     * @param name Keyword to be search
     * @param model Use to pass list of product object to template engine
     * @return product template
     */
    @GetMapping("/search")
    public String findProducts(@RequestParam String name, Model model) {
        List<Product> listOfProducts = productService.getProductsByName(name);
        model.addAttribute("products", listOfProducts);
        return "product";
    }


}
