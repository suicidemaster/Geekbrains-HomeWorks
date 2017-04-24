package ru.geekbrains.java3.dz7;

import ru.geekbrains.java2.Dz2.Exceptions.AppException;

import java.lang.reflect.*;

/**
 * Created by KGBkid on 09.04.2017.
 * Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами
 методов с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в
 качестве параметра передается или объект типа Class, или имя класса. Из «класса-теста» вначале
 должен быть запущен метод с аннотацией @BeforeSuite если такой имеется, далее запущены методы
 с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому
 тесту необходимо также добавить приоритеты(int числа от 1 до 10), в соответствии с которыми будет
 выбираться порядок их выполнения, если приоритет одинаковый то порядок не имеет значения.
 Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
 экземпляре, иначе необходимо бросить исключение при запуске «тестирования».
 */


public class MyApp {

    public static void main(String[] args) {
        start("ru.geekbrains.java3.dz7.Tester");
        start(Tester.class);
    }

    public static void start(String className) {

        try {
            Class sclass = Class.forName(className);
            start(sclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void start(Class classObject) {
        Method[] methods = classObject.getDeclaredMethods();
        try {
            int count1 = 0;
            for (Method o : methods) {

                if (o.getAnnotation(BeforeSuite.class) != null) {
                    if (count1 == 1) throw new TestException();
                    System.out.println(o);
                    count1++;
                }
            }
            for (int i = 1; i < 11; i++) {
                for (Method o : methods) {
                    if (o.getAnnotation(Test.class) != null) {
                        Test test =
                                o.getAnnotation(Test.class);

                        if (test.value() == i) {
                            System.out.println(o);
                            System.out.println("value: " + test.value());
                        }
                    }
                }
            }
            int count2 = 0;
            for (Method o : methods) {
                int count = 0;
                if (o.getAnnotation(AfterSuite.class) != null) {
                    if (count2 == 1) throw new TestException();
                    System.out.println(o);
                    count2++;
                }
            }
        } catch (TestException e) {
            e.printStackTrace();
        }

    }

}
