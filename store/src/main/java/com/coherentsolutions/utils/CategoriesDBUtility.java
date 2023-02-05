package com.coherentsolutions.utils;

import com.coherentsolutions.domain.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesDBUtility extends DBUtility {
    private static final String CREATE_CATEGORIES_TABLE_QUERY = "CREATE TABLE categories (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, name TEXT)";
    private static final String ADD_CATEGORY_ENTRY_QUERY_TEMPLATE = "INSERT INTO categories VALUES (DEFAULT, '%s')";
    private static final String GET_CATEGORY_ID_QUERY_TEMPLATE = "SELECT id FROM categories WHERE name = '%s'";


    public void createCategoriesTable() {
        executeUpdate(CREATE_CATEGORIES_TABLE_QUERY);
    }

    public void addCategoryEntry(Category category) {
        executeUpdate(String.format(ADD_CATEGORY_ENTRY_QUERY_TEMPLATE, category.getName()));
    }

    public int getCategoryId(Category category) {
        ResultSet resultSet = executeQuery(String.format(GET_CATEGORY_ID_QUERY_TEMPLATE, category.getName()));
        Integer categoryId = null;
        try {
            resultSet.next();
            categoryId = resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryId;
    }
}