package com.soultech.productmanagement.controller;

import com.soultech.productmanagement.model.Product;
import com.soultech.productmanagement.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
 * @since 2025-03-24
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
    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }

    /**
     * Handles updating an existing product.
     *
     * @param id The ID of the product to be updated.
     * @param product The updated product data.
     * @return A redirect to the product list page.
     */
    @PutMapping("/{id}/update")
    public String updateAProduct(@PathVariable long id, Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products";
    }
}
