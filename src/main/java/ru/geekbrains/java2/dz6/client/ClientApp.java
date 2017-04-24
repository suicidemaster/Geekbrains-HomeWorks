package ru.geekbrains.java2.dz6.client;

public class ClientApp {

    public static final String SERVER_HOST = "localhost"; //127.0.0.1
    public static final int SERVER_PORT = 1488;

    public static void main(String[] args) {
        new ClientWindow(SERVER_HOST, SERVER_PORT);
    }
}
