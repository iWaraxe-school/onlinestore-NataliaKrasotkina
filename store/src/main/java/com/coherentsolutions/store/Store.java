package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.utils.RandomStorePopulator;

import java.util.ArrayList;
import java.util.List;


public class Store {
    private final List<Category> categoryList;

    public Store() {
        this.categoryList = new ArrayList<Category>();
    }

}
