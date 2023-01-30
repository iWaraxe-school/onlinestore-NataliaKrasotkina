package com.coherentsolutions.store;

import com.coherentsolutions.domain.Product;

import java.util.List;

public class Order extends Thread {

    @Override
    public void run() {
        orderProcessWait();
        Store store = Store.getInstance();
        List<Product> allProducts = store.getAllProducts();
        Product product = allProducts.get((int) (Math.random() * allProducts.size()));
        ShoppingCart.addProduct(product);
    }

    private void orderProcessWait() {
        try {
            Thread.sleep((long) (Math.random() * 30 + 1) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
