package ru.geekbrains.java1.dz2;

/**
 * Created by олег on 16.01.2017.
 */

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dz2 {
    public static void main(String[] args) throws IOException {
        // Задание 1
        int[] num = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        // Задание 2
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) num[i] = 1;
            else if (num[i] == 1) num[i] = 0;
        }
        System.out.println(Arrays.toString(num));
        // Задание 3
        int[] num2 = new int[8];
        for (int i = 0, k = 1; i < num2.length; i++, k += 3) {
            num2[i] = k;
        }
        System.out.println(Arrays.toString(num2));
        // Задание 4
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] = mas[i] * 2;
            }
        }
        System.out.println(Arrays.toString(mas));
        // Задание 5
        int[] mas2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Arrays.sort(mas2);
        System.out.println("Минимальное число в массиве: " + mas2[0]);
        System.out.println("Маскимальное число в массиве: " + mas2[mas2.length - 1]);
        // Задание 6
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое число:");
        int a = Integer.parseInt(reader.readLine());
        System.out.println("Выберите действие:");
        System.out.println("1.Сложение");
        System.out.println("2.Вычитание");
        System.out.println("3.Умножение");
        System.out.println("4.Деление");
        int n = Integer.parseInt(reader.readLine());
        System.out.println("Введите второе число:");
        int b = Integer.parseInt(reader.readLine());
        switch (n){
            case 1:
                System.out.println("Ответ:" + (a + b));
                break;
            case 2:
                System.out.println("Ответ:" + (a - b));
                break;
            case 3:
                System.out.println("Ответ:" + (a * b));
                break;
            case 4:
                if (b != 0) {
                    System.out.println("Ответ:" + (a + b));
                    break;
                } else System.out.println("На 0 делить нельзя.");
                break;
            default:
                System.out.println("Нет такого действия.");
        }
    }

}

