package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.sort.ProductComparator;
import com.coherentsolutions.sort.Sorting;
import com.coherentsolutions.utils.XMLParser;

import java.util.*;


public class Store {
    private Set<Category> categoryList;

    public Store() {
        this.categoryList = new HashSet<>();
    }

    public void printData() {
        for (Category category : categoryList) {
            category.printCategoryName();
            category.printProducts();
        }
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Product> sort(String field) {
        List<Product> allProducts = new ArrayList<>();
        for (Category category : categoryList) {
            allProducts.addAll(category.getProductList());
        }

        Map<String, String> fieldToSort = XMLParser.parseConfig();
        String sorting = fieldToSort.get(field);
        switch (Sorting.valueOf(sorting)) {
            case ASC:
                allProducts.sort(ProductComparator.getComparator(field));
                break;
            case DESC:
                allProducts.sort(ProductComparator.getComparator(field).reversed());
                break;
        }

        return allProducts;
    }

    public void printTopProducts() {
        List<Product> topPriceProducts = sort("price");

        System.out.println(topPriceProducts.subList(0, 5));
    }

    public void quit() {
        //TODO:Need to clarify how to quit
    }
}
