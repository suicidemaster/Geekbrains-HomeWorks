package ru.geekbrains.java3.dz2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KGBkid on 07.03.2017.
 */
public class Table {
    PreparedStatement ps = null;
    Connection conn;
    Statement stmt;

    Table(Connection conn, Statement stmt) {
        this.conn = conn;
        this.stmt = stmt;
    }
//*  Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java
// * приложения.
// * id - порядковый номер записи, первичный ключ
// * prodid - уникальный номер товара
// * title - название товара
// * cost - стоимость
// *  При запуске приложения очистить таблицу и заполнить 10.000 товаров вида:
//            * id_товара 1 товар1 10
//            * id_товара 2 товар2 20
//            * id_товара 3 товар3 30
//            * ...
//            * id_товара 10000 товар10000 100010
//            * т.е. просто тестовые данные
    public void createTable() throws SQLException {
        stmt.execute("DELETE FROM goods"); // Очищаем таблицу
        ps = conn.prepareStatement("INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?)");
        conn.setAutoCommit(false); // Выключаем AutoCommit
        ps.clearBatch();
        for (int i = 1; i < 1001; i++) {

            ps.setInt(1, i);
            ps.setString(2, "id_товара " + i);
            ps.setString(3, "товар" + i);
            ps.setInt(4, i * 10);
            ps.addBatch();
        }

        ps.executeBatch();
        conn.commit();
        System.out.println("Таблица заполнена");
        ps.close();
    }
// *  Написать консольное приложение, которое позволяет узнать цену товара по
// * его имени, либо если такого товара нет, то должно быть выведено сообщение
// * "Такого товара нет". Пример консольной комманды для получения цены:
// * "/цена товар545"
    public int findCostByTitle(String title) throws SQLException {
        ResultSet rs = stmt.executeQuery(
                "select  cost from goods where title = \'" + title + "\';");
        int cost = -1;
        while (rs.next()) {
            cost = rs.getInt("cost");
            System.out.println(rs.getInt("cost"));
        }
        if (cost == -1) {
            System.out.println("Такого товара нет");
        }
        return cost;

    }
// *  В этом же приложении должна быть возможность изменения цены
// * товара(указываем имя товара и новую цену). Пример: "/сменитьцену товар10
// * 10000"
    public void setCostByTitle(String title, int newcost) throws SQLException {
       stmt.execute(
                "update goods  set  cost = \'" + newcost + "\'  where title = \'" + title + "\';");

            System.out.println("Новая цена установлена");


    }
//*  Вывести товары в заданном ценовом диапазоне. Консольная комманда:
//* "/товарыпоцене 100 600"
//*/
    public List<String> findTitleBetweenCost(int cost1, int cost2) throws SQLException {
        ResultSet rs = stmt.executeQuery(
                "select title from goods where cost between " + cost1 + " and " + cost2 + ";");
        List<String> title = new ArrayList<>();
        while (rs.next()) {
            title.add(rs.getString("title").trim());
        }
        System.out.println(title);
        return title;
    }
}
