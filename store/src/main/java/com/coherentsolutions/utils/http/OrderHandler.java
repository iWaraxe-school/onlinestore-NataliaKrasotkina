package com.coherentsolutions.utils.http;

import com.coherentsolutions.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OrderHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Store.getInstance().createOrder();
        httpExchange.sendResponseHeaders(201, 0);
        httpExchange
                .getResponseBody()
                .write(("New order created").getBytes(StandardCharsets.UTF_8));
        httpExchange.close();
    }
}
