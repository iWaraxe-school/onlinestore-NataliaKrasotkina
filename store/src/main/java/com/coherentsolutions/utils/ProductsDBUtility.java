package com.coherentsolutions.utils;

import com.coherentsolutions.domain.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDBUtility extends DBUtility {
    private static final String CREATE_PRODUCTS_TABLE_QUERY = "CREATE TABLE products (id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, category_id INT, name TEXT, price DOUBLE PRECISION, rate DOUBLE PRECISION)";
    private static final String ADD_PRODUCT_ENTRY_QUERY_TEMPLATE = "INSERT INTO products VALUES (DEFAULT, %d, '%s', %s, %s);";
    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";


    public void createProductsTable() {
        executeUpdate(CREATE_PRODUCTS_TABLE_QUERY);
    }

    public void addProductEntry(Product product, int categoryId) {
        executeUpdate(String.format(ADD_PRODUCT_ENTRY_QUERY_TEMPLATE, categoryId, product.getName().replace('\'', ' '), product.getPrice(), product.getRate()));
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = executeQuery(GET_ALL_PRODUCTS_QUERY);
        try {
            while (resultSet.next()) {
                Product product = Product.newProductBuilder()
                        .setName(resultSet.getString("name"))
                        .setPrice(resultSet.getDouble("price"))
                        .setRate(resultSet.getDouble("rate"))
                        .build();
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}