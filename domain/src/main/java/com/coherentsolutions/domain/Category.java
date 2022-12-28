package com.coherentsolutions.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public Category(String name) {
        this.name = name;
        this.productList = new ArrayList<Product>();
    }

    public void printProducts() {
        System.out.println(productList);
    }
    public void printCategoryName(){
        System.out.println(name);
    }

    public void setProductList (List<Product> productList){
        this.productList = productList;
    }

    public String getName() {
        return name;
    }
}
