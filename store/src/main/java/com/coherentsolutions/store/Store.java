package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
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
}
