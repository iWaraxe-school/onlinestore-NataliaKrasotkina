package com.coherentsolutions.utils.http;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    private static final int PORT = 8081;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";


    public void startServer() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            createContext(httpServer, "/categories", new CategoriesHandler());
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            httpServer.setExecutor(threadPoolExecutor);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContext(HttpServer server, String path, HttpHandler handler) {
        server.createContext(path, handler).setAuthenticator(new BasicAuthenticator("test") {
            @Override
            public boolean checkCredentials(String user, String password) {
                return user.equals(USERNAME) && password.equals(PASSWORD);
            }
        });
    }
}