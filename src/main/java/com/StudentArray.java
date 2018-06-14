package com;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class StudentArray {

    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String driverName = "org.postgresql.Driver";
    private static String username = "postgres";
    private static String password = "qwerty";
    private static java.sql.Connection connection;

    public static ArrayList<String> getArrayStudentName() throws SQLException {
        connection = createConnection();
        ArrayList<String> strings = new ArrayList<String>();

        PreparedStatement ps2 = connection.prepareStatement("SELECT name FROM student");
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            strings.add(rs2.getString(1));
        }
        strings.forEach(s -> System.out.println(s));
        return strings;
    }


    public static java.sql.Connection createConnection() {
        connection = null;
        System.out.println("-------- PostgreSQL JDBC ConnectionToPostgreSQL Testing ------------");
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ConnectionToPostgreSQL Failed! Check output console");
            e.printStackTrace();
        }
        System.out.println("PostgreSQL JDBC Driver Registered!");
        return connection;
    }

}
