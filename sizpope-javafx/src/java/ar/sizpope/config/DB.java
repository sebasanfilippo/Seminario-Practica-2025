package ar.sizpope.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static String url;
    private static String user;
    private static String pass;

    public static void configure(String url, String user, String pass){
        Db.url = url; Db.user = user; Db.pass = pass;
    }
    public static Connection get() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}

