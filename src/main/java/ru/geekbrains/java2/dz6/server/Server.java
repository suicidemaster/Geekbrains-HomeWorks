package ru.geekbrains.java2.dz6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int serverPort;
    private ServerSocket serverSocket;


    public Server(int port) {
        serverPort = port;

        Socket socket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server created. Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
            ServerWindow serverWindow = new ServerWindow(socket);
            Runnable threadData = new ClientHandler(socket, serverWindow);
            Thread thread = new Thread(threadData);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                System.out.println("serverSocket.Server closed.");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
