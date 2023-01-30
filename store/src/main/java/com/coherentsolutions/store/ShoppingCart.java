package com.coherentsolutions.store;

import com.coherentsolutions.domain.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {
    private static List<Product> purchasedGoods = new CopyOnWriteArrayList<>();

    public static void addProduct(Product product) {
        purchasedGoods.add(product);
    }

    public static void clearShoppingCart() {
        purchasedGoods.clear();
    }
}