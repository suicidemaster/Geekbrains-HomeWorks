package ru.geekbrains.java1.dz1;

/**
 * Created by олег on 13.01.2017.
 */
public class Hello_World {
    public static void main(String[] args) {
    byte bb = 125;
    short sh = 12313;
    int i = 12321313;
    long l = 123124124124124L;
    char ch = '\u1234';
    boolean bool = true;
    float f = 1.0f;
    double dd = 1.0;
    System.out.println(math(3, 6, 7, 3));
    System.out.println(method(7, 3));
    System.out.println(leapYear(801));
    }
    public static int math(int a, int b, int c, int d)

    {
        return a * (b + (c / d));
    }
    public static boolean method(int a, int b)
    {
        int s = a + b;
        if (s<10)return false;
        else if (s>20) return false;
        else return true;
    }
    public static boolean leapYear(int a)
    {
        if (a%4 == 0)
        {
            if (a%100 == 0)
            {
                if (a%400 == 0) return true;
                else return false;
            }
            else return true;
        }
        else return false;

    }
}
