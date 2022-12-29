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

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                '}';
    }
}
