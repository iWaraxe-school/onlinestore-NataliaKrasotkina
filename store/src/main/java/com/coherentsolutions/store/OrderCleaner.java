package com.coherentsolutions.store;


import java.util.concurrent.TimeUnit;

public class OrderCleaner extends Thread {

    @Override
    public void run() {
        while (true) {
            cleanProcessWait();
            ShoppingCart.getInstance().clearShoppingCart();
        }
    }

    private void cleanProcessWait() {
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}