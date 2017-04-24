package ru.geekbrains.java2.dz6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientHandler implements Runnable {

    private Socket socket;
//    private PrintWriter out;
//    private Scanner in;
    private ServerWindow serverWindow;


    public ClientHandler(Socket socket, ServerWindow serverWindow) {
//        try {
            this.socket = socket;
            this.serverWindow = serverWindow;
//            in = new Scanner(socket.getInputStream());
//            out = new PrintWriter(socket.getOutputStream());


//        } catch (IOException e) {
//        }
    }

    @Override
    public void run() {
        while (true) { // socket.isConnected()

            if (serverWindow.in.hasNext()) {
                String message = serverWindow.in.nextLine();
                ServerWindow.serverMessageHistory.append("Client: " + message + "\n");


                if (message.equalsIgnoreCase("END")) break;
            }
        }

        try {
            System.out.println("Client disconnected");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
