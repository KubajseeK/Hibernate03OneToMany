package sk.itsovy.kutka;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";


        try {

            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}