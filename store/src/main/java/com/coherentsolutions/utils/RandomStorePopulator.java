package com.coherentsolutions.utils;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class RandomStorePopulator {
    private Store store;
    public static RandomProductGenerator generator = new RandomProductGenerator();

    public RandomStorePopulator(Store store ) {
        this.store = store;
    }

    public Set <Category> createCategories () {
        Set <Category> categories = new HashSet<>();
        Reflections reflections = new Reflections("com.coherentsolutions.domain.categories");
        Set<Class<? extends Category >>  subCategoryClasses = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> subCategoryClass : subCategoryClasses){
            try {
                categories.add(subCategoryClass.getConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categories;
    }

    public void fillStore() {
        Set <Category> categories = createCategories();

        for (Category category : categories){
            category.setProductList(generator.getProducts(category.getName(), 4));
        }
        store.setCategoryList(categories);
    }
}
