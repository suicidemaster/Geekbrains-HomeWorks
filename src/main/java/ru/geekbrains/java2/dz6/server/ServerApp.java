package ru.geekbrains.java2.dz6.server;

public class ServerApp {
    public static final int PORT = 1488;

    public static void main(String[] args) {
        new Server(PORT);
    }
}
