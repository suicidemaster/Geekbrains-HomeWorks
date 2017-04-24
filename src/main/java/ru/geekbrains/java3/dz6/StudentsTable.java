package ru.geekbrains.java3.dz6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by KGBkid on 04.04.2017.
 */
public class StudentsTable {
    PreparedStatement ps = null;
    Connection conn;
    Statement stmt;

    StudentsTable(Connection conn, Statement stmt) {
        this.conn = conn;
        this.stmt = stmt;
    }

    public void createTable() throws SQLException {
        stmt.execute("DELETE FROM students"); // Очищаем таблицу
        ps = conn.prepareStatement("INSERT INTO students (id, lastname, grade) VALUES (?, ?, ?)");
        conn.setAutoCommit(false); // Выключаем AutoCommit
        ps.clearBatch();
        for (int i = 1; i < 10; i++) {

            ps.setInt(1, i);
            ps.setString(2, "фамилия" + i);
            ps.setInt(3, i % 5);
            ps.addBatch();
        }

        ps.executeBatch();
        conn.commit();
        System.out.println("Таблица заполнена");
        ps.close();
    }

    public void addStudent(int id, String lastname, int grade) throws SQLException {
        ps = conn.prepareStatement("INSERT FROM students (id, lastname, grade) VALUES (?, ?, ?)");
        conn.setAutoCommit(false); // Выключаем AutoCommit
        ps.clearBatch();
        ps.setInt(1, id);
        ps.setString(2, lastname);
        ps.setInt(3, grade);
        ps.executeBatch();
        conn.commit();
        System.out.println("Студент добавлен");
        ps.close();
    }

    public void removeStudent(int id) throws SQLException {
        stmt.execute(
                "delete from students  where  id = \'" + id + "\';");

        System.out.println("Студент удален");
    }

}
