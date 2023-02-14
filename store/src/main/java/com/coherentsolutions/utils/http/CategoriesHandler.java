package com.coherentsolutions.utils.http;


import com.coherentsolutions.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CategoriesHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        List<String> categoriesNames = Store.getInstance().getAllCategoriesNames();
        httpExchange.sendResponseHeaders(200, 0);
        httpExchange
                .getResponseBody()
                .write(("Categories: " + categoriesNames).getBytes(StandardCharsets.UTF_8));
        httpExchange.close();
    }
}
