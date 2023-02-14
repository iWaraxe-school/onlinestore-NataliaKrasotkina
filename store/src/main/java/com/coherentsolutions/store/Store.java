package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.sort.ProductComparatorGenerator;
import com.coherentsolutions.sort.Sorting;
import com.coherentsolutions.utils.CategoriesDBUtility;
import com.coherentsolutions.utils.ProductsDBUtility;
import com.coherentsolutions.utils.XMLParser;

import java.util.*;


public class Store {
    private static final Store instance = new Store();
    private CategoriesDBUtility categoriesDBUtility;
    private ProductsDBUtility productsDBUtility;

    private Store() {
        categoriesDBUtility = new CategoriesDBUtility();
        productsDBUtility = new ProductsDBUtility();
    }

    public static Store getInstance() {
        return instance;
    }

    public void createOrder() {
        Order order = new Order();
        order.start();
    }

    public void cleanOrder() {
        OrderCleaner orderCleaner = new OrderCleaner();
        orderCleaner.start();
    }

    public void saveData(Set<Category> categoryList) {
        categoriesDBUtility.createCategoriesTable();
        productsDBUtility.createProductsTable();
        for (Category category : categoryList) {
            saveCategoryDataInDB(category);
        }
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

    public void printAllProducts() {
        List<Product> allProducts = getAllProducts();
        System.out.println(allProducts);
    }

    public List<Product> getAllProducts() {
        return productsDBUtility.getAllProducts();
    }

    public List<String> getAllCategoriesNames() {
        return categoriesDBUtility.getAllCategoriesNames();
    }

    private void saveCategoryDataInDB(Category category) {
        categoriesDBUtility.addCategoryEntry(category);
        int categoryId = categoriesDBUtility.getCategoryId(category);

        for (Product product : category.getProductList()) {
            productsDBUtility.addProductEntry(product, categoryId);
        }
    }
}