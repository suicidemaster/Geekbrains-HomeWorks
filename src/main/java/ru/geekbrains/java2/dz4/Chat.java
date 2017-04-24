package ru.geekbrains.java2.dz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by олег on 11.02.2017.
 */
public class Chat extends JFrame {

    Font btnFont = new Font("Times New Roman", Font.PLAIN, 16);

    public Chat() {
        setSize(505, 587);
        setResizable(false);
        setLocation(400, 100);
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new BorderLayout());
        add(topPanel, BorderLayout.CENTER);
        topPanel.setBackground(new Color(140, 140, 140));

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.setPreferredSize(new Dimension(1, 30));
        add(bottomPanel, BorderLayout.SOUTH);

        topPanel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        topPanel.add(scrollPane);
        textArea.setEditable(false);

        JTextField textField = new JTextField();
        // В следующей строке нужно указать путь файла в который мы будем записывать архив
        String filePath = "C:\\Users\\олег\\IdeaProjects\\geekbrains\\java1\\archive.txt";

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + textField.getText());
                textArea.append(textField.getText());
                textArea.append("\r");
                textArea.append("\n");
                try {

                    PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true));
                    printWriter.write(textField.getText());
                    printWriter.append('\r');
                    printWriter.append('\n');
                    printWriter.close();
                } catch (
                        IOException е)

                {
                    System.out.println("Произошла ошибка при работе с файлами");
                }
                textField.setText("");
            }
        });
        bottomPanel.add(textField, BorderLayout.CENTER);
        JButton sendButton = new JButton("Send");
        sendButton.setFont(btnFont);


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Your message: " + textField.getText());
                textArea.append(textField.getText());
                textArea.append("\r");
                textArea.append("\n");
                try {
                    PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true));
                    printWriter.write(textField.getText());
                    printWriter.append('\r');
                    printWriter.append('\n');
                    printWriter.close();
                } catch (
                        IOException е)

                {
                    System.out.println("Произошла ошибка при работе с файлами");
                }
                textField.setText("");
            }
        });
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Сохраняем написанный текст в файл


        setVisible(true);
    }
}
