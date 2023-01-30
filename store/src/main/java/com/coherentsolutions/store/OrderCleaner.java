package com.coherentsolutions.store;


public class OrderCleaner extends Thread {

    @Override
    public void run() {
        while (true) {
            cleanProcessWait();
            ShoppingCart.clearShoppingCart();
        }
    }

    private void cleanProcessWait() {
        try {
            Thread.sleep(2 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
