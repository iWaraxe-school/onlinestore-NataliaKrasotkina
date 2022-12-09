package com.coherentsolutions;

import com.coherentsolutions.store.Store;
import com.coherentsolutions.utils.RandomStorePopulator;
import java.util.Map;

public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();
        RandomStorePopulator populator = new RandomStorePopulator(store);
        populator.fillStore();

        store.printData();
    }
}