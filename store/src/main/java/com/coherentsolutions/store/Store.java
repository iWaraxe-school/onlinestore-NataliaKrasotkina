package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.utils.RandomProductGenerator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Store {

    private List<Category> categoryList;
    private RandomProductGenerator productGenerator;


    public Store() {
        this.categoryList = new ArrayList<>();
        this.productGenerator = new RandomProductGenerator();
    }

    public void initStore(Map<Category, Integer> categoryProductMap) {
        Class<Category> categoryClass = Category.class;
        for (Map.Entry<Category, Integer> entry : categoryProductMap.entrySet()) {
            Category category = entry.getKey();
            Integer productNumber = entry.getValue();

            try {
                Field categoryNameField = categoryClass.getDeclaredField("name");
                categoryNameField.setAccessible(true);
                Field productListField = categoryClass.getDeclaredField("productList");
                productListField.setAccessible(true);

                String categoryName = (String) categoryNameField.get(category);
                List<Product> products = productGenerator.getProducts(categoryName, productNumber);
                ((ArrayList) (productListField.get(category))).add(products);
            } catch (Exception ex) {
            }
            categoryList.add(category);
        }

    }

    public void printData() {
        for (Category category : categoryList) {
            category.printCategoryName();
            category.printProducts();
        }


    }
}
