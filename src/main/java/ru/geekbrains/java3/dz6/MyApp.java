package ru.geekbrains.java3.dz6;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Created by KGBkid on 04.04.2017.
 * Написать метод, которому в качестве аргумента передается не пустой одномерный
 * целочисленный массив, метод должен вернуть новый массив, который получен путем
 * вытаскивания элементов из исходного массива, идущих после последней четверки. Входной
 * массив должен содержать хотя бы одну четверку, в противном случае в методе необходимо
 * выбросить RuntimeException.
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 * вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ]
 *  Написать метод, который проверяет что массив состоит только из чисел 1 и 4. Если в массиве
 * нет хоть одной 4 или 1, то метод вернет false;
 * Написать набор тестов для этого метода (варианта 3-4 входных данных)
 *  Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для
 * проверки того, что при работе с базой корректно добавляются, обновляются и читаются
 * записи. Следует учесть что в базе есть заранее добавленные записи, и после проведения
 * тестов эти записи не должны быть удалены/именены/добавлены.
 */
public class MyApp {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "123456";

    public static void main(String[] args) {
        int array[] = {1, 5, 3, 4, 2, 4, 3, 4, 3, 5, 3, 7};
        Method method = new Method();
        System.out.println(Arrays.toString(method.myMethodOne(array)));
        System.out.println(method.myMethodTwo(method.myMethodOne(array)));


        Connection conn = null;

        Statement stmt = null;

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            conn = DriverManager.getConnection(dbUrl, user, password);
            stmt = conn.createStatement();
            StudentsTable studentsTable = new StudentsTable(conn, stmt);

            studentsTable.createTable();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                conn.close();
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}

