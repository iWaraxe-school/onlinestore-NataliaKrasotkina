package com.coherentsolutions;


import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.categories.Bike;
import com.coherentsolutions.domain.categories.Milk;
import com.coherentsolutions.domain.categories.Phone;
import com.coherentsolutions.store.Store;
import com.coherentsolutions.utils.RandomStorePopulator;

import java.util.HashMap;
import java.util.Map;

public class StoreApp {
    private static Map<Category, Integer> categoryProductMap;

    public static void main(String[] args) {
        categoryProductMap = new HashMap<Category, Integer>();
        categoryProductMap.put(new Milk(), 3);
        categoryProductMap.put(new Bike(), 3);
        categoryProductMap.put(new Phone(), 3);

        Store store = new Store();
        store.initStore(categoryProductMap);
        store.printData();


    }
}