package com.coherentsolutions.domain;

public class Product {
    private final String name;
    private final Double price;
    private final Double rate;

    public Product(String name, Double price, Double rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }
}
