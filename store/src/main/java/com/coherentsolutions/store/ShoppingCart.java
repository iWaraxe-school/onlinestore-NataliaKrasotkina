package com.coherentsolutions.store;

import com.coherentsolutions.domain.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {
    private static List<Product> purchasedGoods;
    private static final ShoppingCart instance = new ShoppingCart();

    private ShoppingCart() {
        purchasedGoods = new CopyOnWriteArrayList<>();
    }

    public static ShoppingCart getInstance() {
        return instance;
    }

    public void addProduct(Product product) {
        purchasedGoods.add(product);
    }

    public void clearShoppingCart() {
        purchasedGoods.clear();
    }
}