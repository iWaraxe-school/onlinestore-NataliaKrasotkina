package com.coherentsolutions.utils;

import com.coherentsolutions.domain.Product;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class RandomProductGenerator {
    private final Faker faker = new Faker();

    public Product generateProduct(String categoryName) {
        return new Product(getProductName(categoryName), getPrice(), getRate());
    }

    private String getProductName(String categoryName) {
        switch (categoryName) {
            case "Milk":
                return faker.food().ingredient();
            case "Phone":
                return faker.space().galaxy();
            case "Bike":
                return faker.starTrek().character();
            default:
                return null;

        }
    }

    private Double getPrice() {
        return faker.number().randomDouble(2, 1, 100);
    }

    private Double getRate() {
        return faker.number().randomDouble(1, 1, 10);
    }

    public List<Product> getProducts(String categoryName, int productNumber) {
        List<Product> products = new ArrayList<>();
        for (int p = 0; p < productNumber; p++) {
            Product product = generateProduct(categoryName);
            products.add(product);

        }
        return products;
    }
}
