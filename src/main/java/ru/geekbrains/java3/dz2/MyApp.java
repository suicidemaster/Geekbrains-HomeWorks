package ru.geekbrains.java3.dz2;

import java.sql.*;

/**
 * Created by KGBkid on 07.03.2017.
 * <p>
*/
public class MyApp {
    public static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    public static String user = "postgres";
    public static String password = "123456";

    public static void main(String[] args) {
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
            Table table = new Table(conn, stmt);

            table.createTable();
            table.findCostByTitle("товар443");
            table.setCostByTitle("товар443", 443);
            table.findCostByTitle("товар443");
            table.findTitleBetweenCost(100, 204);

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
