package org.example.MysqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public abstract class Connexion {
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/Gestion_Absence";
    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            return null;
        }
    }



}


