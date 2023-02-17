package com.coherentsolutions;

import com.coherentsolutions.store.Store;
import com.coherentsolutions.utils.RandomStorePopulator;
import com.coherentsolutions.utils.http.Client;
import com.coherentsolutions.utils.http.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StoreApp {

    public static void main(String[] args) throws IOException {

        Store store = Store.getInstance();

        RandomStorePopulator populator = new RandomStorePopulator(store);
        populator.fillStore();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRunning = true;
        boolean isOrderCleanerOn = false;

        Server server = new Server();
        server.startServer();
        Client client = new Client();
        client.makeCategoriesRequest();

        while (isRunning) {
            System.out.println("Please enter command: ");
            switch (bufferedReader.readLine()) {
                case "sort":
                    store.sortByXml();
                    break;
                case "top":
                    store.printTopProducts();
                    break;
                case "print all":
                    store.printAllProducts();
                    break;
                case "create order":
                    client.makeCreateOrderRequest();
                    if (!isOrderCleanerOn) {
                        store.cleanOrder();
                        isOrderCleanerOn = true;
                    }
                    break;
                case "quit":
                    isRunning = false;
                    break;

                default:
                    System.out.println("Command is not supported.");
            }
        }
    }
}