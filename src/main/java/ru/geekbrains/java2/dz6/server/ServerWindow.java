package ru.geekbrains.java2.dz6.server;

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

public class ServerWindow extends JFrame {

    private JTextField serverMessageText;
    public static JTextArea serverMessageHistory;


    Socket socket;
    static Scanner in;
    PrintWriter out;

    public ServerWindow(Socket socket) {

        this.socket = socket;
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        initUX();
    }


    private void initUX() {
        setBounds(200, 200, 500, 500);
        setTitle("Server's window");

        //многострочный элемент для всех сообщений
        serverMessageHistory = new JTextArea();
        serverMessageHistory.setEditable(false);
        serverMessageHistory.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(serverMessageHistory);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputMessagePanel = new JPanel(new BorderLayout());
        add(inputMessagePanel, BorderLayout.SOUTH);

        //кнопка отправки сообщения
        JButton sendButton = new JButton("SEND");
        inputMessagePanel.add(sendButton, BorderLayout.EAST);
        serverMessageText = new JTextField();
        inputMessagePanel.add(serverMessageText, BorderLayout.CENTER);

        //отправка по кнопке
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = serverMessageText.getText();
                sendMessage(message);
                serverMessageText.grabFocus();
            }
        });

        //отправка по Enter
        serverMessageText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = serverMessageText.getText();
                sendMessage(message);
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

        setVisible(true);
    }

    public void sendMessage(String message) {
        if (!message.trim().isEmpty()) {
            serverMessageHistory.append("Server: " + message + "\n");
            out.println(message);
            out.flush();
            serverMessageText.setText("");
        }
    }
}
