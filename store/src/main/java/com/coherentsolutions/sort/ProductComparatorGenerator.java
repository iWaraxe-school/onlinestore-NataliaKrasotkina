package com.coherentsolutions.sort;

import com.coherentsolutions.domain.Product;

import java.util.Comparator;

public class ProductComparatorGenerator {

    //Factory method is already implemented in ProductComparatorGenerator class, method: getComparator returns different comparator’s objects depending on parameter “field” value.

    public static Comparator<Product> getComparator(String field) {
        switch (field) {
            case "name":
                return Comparator.comparing(Product::getName, String.CASE_INSENSITIVE_ORDER);
            case "rate":
                return Comparator.comparing(Product::getRate);
            case "price":
                return Comparator.comparing(Product::getPrice);
            default:
                System.out.println("Unknown Field " + field);
                return null;
        }
    }
}