package com.coherentsolutions.utils;

import com.github.javafaker.Faker;

public class RandomStorePopulator {
    private final Faker faker = new Faker();

    public String getProductName(String categoryName) {
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
    public Double getPrice() {
        return faker.number().randomDouble(2, 1, 100);
    }

    public Double getRate() {
        return faker.number().randomDouble(1, 1, 10);
    }
}
