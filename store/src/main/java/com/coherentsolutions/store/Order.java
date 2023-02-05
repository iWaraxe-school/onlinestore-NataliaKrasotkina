package com.coherentsolutions.store;

import com.coherentsolutions.domain.Product;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Order extends Thread {

    @Override
    public void run() {
        orderProcessWait();
        Store store = Store.getInstance();
        List<Product> allProducts = store.getAllProducts();
        Product product = allProducts.get((int) (Math.random() * allProducts.size()));
        ShoppingCart.getInstance().addProduct(product);
    }

    private void orderProcessWait() {
        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 30 + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}