package ru.geekbrains.java3.dz3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by KGBkid on 11.03.2017.
 * Домашнее задание:
 */
public class Dz3 {

    public static void main(String[] args) {

// 1) Прочитать файл(около 50 байт) в байтовый массив и вывести этот массив в консоль;
        Exercise1 ex1 = new Exercise1();
// 2) Последовательно сшить 10 файлов в один(файлы также ~100 байт).
// Может пригодиться следующая конструкция:
// ArrayList<FileInputStream> al = new ArrayList<>();
// ...
//Enumeration<FileInputStream> e = Collections.enumeration(al);
        ArrayList<FileInputStream> arrayList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            try {
                FileInputStream in = new FileInputStream(i + ".txt");
                arrayList.add(in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Exercise2 ex2 = new Exercise2(arrayList);
// 3)  которое Написать консольное приложение, умеет постранично читать текстовые файлы(размером > 10 mb),
// вводим страницу, программа выводит ее в консоль(за страницу можно принимаем 1800 символов).
// Время чтения файла должно находится в разумных пределах
// (программа не должна загружаться дольше 10 секунд), ну и чтение тоже не должно занимать >5 секунд.
// Чтобы не было проблем с кодировкой используйте латинские буквы.
        Exercise3 ex3 = new Exercise3("12345.txt");

    }
}
