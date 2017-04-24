package ru.geekbrains.java2.dz8.server;

import ru.geekbrains.java2.dz8.exceptions.AuthFailException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler implements Runnable {
    private Socket socket;
    private Server server;

    private DataOutputStream out;
    private DataInputStream in;

    private static int clientsCount = 0;
    private String clientName;

    public ClientHandler(Socket socket, Server server) {
        try {
            this.socket = socket;
            this.server = server;

            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            clientsCount++;
            clientName = "client" + clientsCount;

            System.out.println("Client \"" + clientName + "\" ready!");
        } catch (IOException e) {
        }
    }

    @Override
    public void run() {
        waitForAuth();
        waitForMessage();
    }

    private void waitForMessage() {
        while (true) {
            String message = null;
            try {
                message = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(clientName + ": " + message);

                new Thread(new MessagesSender(message, clientName, server)).start();
        }
    }

    private void waitForAuth() {
        while (true) {
            String message = null;
            try {
                message = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isAuthOk(message)) {
                    out.writeUTF("signIn_success");
                    break;
                } else {
                    out.writeUTF("signIn_fail");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(clientName + " auth ok and is ready for chat!");
    }

    private boolean isAuthOk(String message) {
        System.out.println(clientName + "[NO AUTH]: " + message);

        if (message != null) {
            String[] parsedMessage = message.split("___");
            if (parsedMessage.length == 3) {
                try {
                    processAuthMessage(parsedMessage);
                    return true;
                } catch (AuthFailException e) {
                    return false;
                }
            }
        }
        return false;
    }

    private void processAuthMessage(String[] parsedMessage) throws AuthFailException {
        if (parsedMessage[0].equals("auth")) {
            System.out.println("Auth message from " + clientName);
            String login = parsedMessage[1];
            String password = parsedMessage[2];

            String nick = null;
            try {
                nick = SQLHandler.getNick(login, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new AuthFailException();
            }

            if(nick != null) {
                server.addClient(this, nick);
                return;
            }
            throw new AuthFailException();
        }
    }

    public DataOutputStream getOut() {
        return out;
    }
    public String getClientName() {
        return clientName;
    }

    public void setNick(String nick) {
        this.clientName = nick;
    }
}
