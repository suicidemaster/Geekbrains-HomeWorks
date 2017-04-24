package ru.geekbrains.java3.dz3;

import java.io.*;
import java.util.Arrays;

/**
 * Created by KGBkid on 11.03.2017.
 */
public class Exercise1 {

    FileInputStream in = null;
    int i;
    Exercise1() {

        try {
            in = new FileInputStream("12345.txt");
            byte[] bw = new byte[in.available()];
            in.read(bw);

            System.out.println(new String(bw, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
