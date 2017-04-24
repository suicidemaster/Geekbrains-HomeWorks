package ru.geekbrains.java1.dz.dz6.MoshkovOleg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by олег on 29.01.2017.
 */
public class FileAppend {

    public static void main(String args[]) {
        int i;
        FileInputStream fin1 = null;
        FileInputStream fin2 = null;
        FileOutputStream fout = null;
        try {
            fin1 = new FileInputStream("1.txt");
            fin2 = new FileInputStream("2.txt");
            fout = new FileOutputStream("3.txt");
            do {
                i = fin1.read();
                if (i == -1) {
                    fout.write('\r');
                    fout.write('\n');
                    do {
                        i = fin2.read();
                        if (i != -1) fout.write(i);
                    } while (i != -1);
                }
                if (i != -1) fout.write(i);
            } while (i != -1);
            if (fin1 != null) fin1.close();
            if (fin2 != null) fin2.close();
            if (fout != null) fout.close();
        } catch (
                IOException е)

        {
            System.out.println("Произошла ошибка при работе с файлами");
        }
    }
}
