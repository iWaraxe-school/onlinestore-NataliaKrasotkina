package com.coherentsolutions;

import com.coherentsolutions.store.Store;
import com.coherentsolutions.utils.RandomStorePopulator;


public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();
        RandomStorePopulator populator = new RandomStorePopulator(store);
        populator.fillStore();

        store.printTopProducts();
        store.printData();

    }
}