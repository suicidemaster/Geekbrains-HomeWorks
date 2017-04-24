package ru.geekbrains.java3.dz3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

/**
 * Created by KGBkid on 12.03.2017.
 */
public class Exercise3 {

    public Exercise3(String name) {

        long time0 = System.currentTimeMillis();
        List<String> lines = null;
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();


        FileInputStream in = null;
        int i = 0;
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер страницы, которую будем выводить");

        try {
            in = new FileInputStream(name);
            i = Integer.parseInt(reader.readLine()) - 1;
            byte[] content = new byte[in.available()];
            in.read(content);
            System.out.println(new String(content, "UTF-8").substring(i * 1800, (i + 1) * 1800));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long time1 = System.currentTimeMillis();
            System.out.println((time1 - time0) + " Время работы с массивом byte");
        }
    }
}

