package com.coherentsolutions.utils;

import com.coherentsolutions.domain.Product;

public class RandomStorePopulator {
    public static RandomProductGenerator generator = new RandomProductGenerator();
    public static void showProduct(String category){
        Product product = generator.generateProduct(category);
        System.out.println(product);



    }
}
