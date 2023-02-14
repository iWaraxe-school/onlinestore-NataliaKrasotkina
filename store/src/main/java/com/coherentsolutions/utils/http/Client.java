package com.coherentsolutions.utils.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8081;
    private static final String PROTOCOL = "http";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public HttpURLConnection getConnection(String path, String method) {
        HttpURLConnection connection = null;
        try {
            URL address = new URL(PROTOCOL, HOST, PORT, path);
            connection = (HttpURLConnection) address.openConnection();
            connection.setRequestMethod(method);
            Base64.Encoder encoder = Base64.getEncoder();
            String auth = USERNAME + ":" + PASSWORD;
            connection.setRequestProperty("Authorization", "Basic " + encoder.encodeToString(auth.getBytes(StandardCharsets.UTF_8)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}