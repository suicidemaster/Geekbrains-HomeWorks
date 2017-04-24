package ru.geekbrains.java2.dz6.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame {

    private JTextField messageText;
    private JTextArea messageHistory;

    final String serverHost;
    final int serverPort;

    Socket socket;
    Scanner in;
    PrintWriter out;

    public ClientWindow(String host, int port) {
        serverHost = host;
        serverPort = port;

        initConnection();
        initUX();
        initServerListener();
    }

    private void initConnection() {
        try {
            socket = new Socket(serverHost, serverPort);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initUX() {
        setBounds(700, 200, 500, 500);
        setTitle("Client's window");


        //многострочный элемент для всех сообщений
        messageHistory = new JTextArea();
        messageHistory.setEditable(false);
        messageHistory.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageHistory);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputMessagePanel = new JPanel(new BorderLayout());
        add(inputMessagePanel, BorderLayout.SOUTH);

        //кнопка отправки сообщения
        JButton sendButton = new JButton("SEND");
        inputMessagePanel.add(sendButton, BorderLayout.EAST);
        messageText = new JTextField();
        inputMessagePanel.add(messageText, BorderLayout.CENTER);

        //отправка по кнопке
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageText.getText();
                sendMessage(message);
                messageText.grabFocus();
            }
        });

        //отправка по Enter
        messageText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageText.getText();
                sendMessage(message);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                closeConnections();
            }
        });

        setVisible(true);
    }

    private void closeConnections() {
        try {
            out.println("END");
            out.flush();
            socket.close();
            out.close();
            in.close();
        } catch (IOException exc) {
        }
    }

    private void initServerListener() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (in.hasNext()) {
                            String message = in.nextLine();
                            messageHistory.append("Server: " + message + "\n");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage(String message) {
        if (!message.trim().isEmpty()) {
            messageHistory.append("Client: " + message + "\n");
            out.println(message);
            out.flush();
            messageText.setText("");
        }
    }
}
