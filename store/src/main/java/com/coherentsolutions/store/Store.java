package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.sort.ProductComparatorGenerator;
import com.coherentsolutions.sort.Sorting;
import com.coherentsolutions.utils.XMLParser;

import java.util.*;


public class Store {
    private Set<Category> categoryList;
    private static Store instance;

    private Store() {
        this.categoryList = new HashSet<>();
    }

    //Singleton
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
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

    public List<Product> sortByXml() {
        List<Product> allProducts = getAllProducts();

        Map<String, String> fieldToSort = XMLParser.parseConfig();
        List<Comparator<Product>> comparators = new ArrayList<>();
        for (Map.Entry<String, String> entry : fieldToSort.entrySet()) {
            Sorting sorting = Sorting.valueOf(entry.getValue());
            String field = entry.getKey();

            switch (sorting) {
                case ASC:
                    comparators.add(ProductComparatorGenerator.getComparator(field));
                    break;
                case DESC:
                    comparators.add(ProductComparatorGenerator.getComparator(field).reversed());
                    break;
            }
        }

        Comparator<Product> generalComparator = comparators.get(0);
        for (int i = 1; i < comparators.size(); i++) {
            generalComparator = generalComparator.thenComparing(comparators.get(i));
        }
        allProducts.sort(generalComparator);
        return allProducts;
    }

    public void printTopProducts() {
        List<Product> allProducts = getAllProducts();
        allProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        System.out.println(allProducts.subList(0, 5));
    }

    private List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        for (Category category : categoryList) {
            allProducts.addAll(category.getProductList());
        }
        return allProducts;
    }
}
