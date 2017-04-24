package ru.geekbrains.java1.dz.dz6.MoshkovOleg;

import java.io.*;

/**
 * Created by олег on 29.01.2017.
 */
public class TextSearcher {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите слово которое будем искать");
        String word = br.readLine();
        try {

            fis = new FileInputStream("1.txt");
            byte[] content = new byte[fis.available()];
            fis.read(content);
            if (fis != null) fis.close();
            String text = new String(content, "Cp1251");
            if (text.contains(word)) System.out.println("Данное слово есть в тексте.");
            else System.out.println("Слова " + word + " в тексте нет.");
        } catch (
                IOException е)

        {
            System.out.println("Произошла ошибка при работе с файлами");
        }
    }
}