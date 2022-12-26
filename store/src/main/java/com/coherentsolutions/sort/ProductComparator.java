package com.coherentsolutions.sort;

import com.coherentsolutions.domain.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }

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
