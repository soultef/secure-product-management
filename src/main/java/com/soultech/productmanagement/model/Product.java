package com.soultech.productmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/**
 * Represents a product in the e-commerce application.
 * A product has an ID, name, description, and price.
 * This class serves as a model for storing product-related data.
 *
 * @author Solomon Demisse
 * @version 1.0
 * @since 2025-03-20
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;



    private String description;
    private double price;

    // No arg constructor
    public Product() {}


    public Product(Long id, String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
