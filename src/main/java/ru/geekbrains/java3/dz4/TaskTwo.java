package ru.geekbrains.java3.dz4;

import java.io.*;

/**
 * Created by KGBkid on 20.03.2017.
 */
public class TaskTwo {
    //    Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл
// (штук по 10 записей, с периодом в 20 мс)
    BufferedReader reader;
    BufferedWriter writer;
    String temp;
    FileOutputStream out;


    public TaskTwo() {
        try {
            reader = new BufferedReader(new FileReader("in.txt"));
//            writer = new BufferedWriter(new FileWriter("out2.txt"));
            out = new FileOutputStream("out2.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeByLines() {
        System.out.println(Thread.currentThread().getName() + " начинает записывать в файл.");
        try {
            for (int i = 0; i < 10; i++) {
                if ((temp = reader.readLine()) != null) {
                    byte[] content;
                    content = temp.getBytes();
//                    writer.write(temp); - не заработало
                    out.write(content);
                    out.write('\r');
                    out.write('\n');
                    Thread.currentThread().sleep(20);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " закончил запись");
    }
}
