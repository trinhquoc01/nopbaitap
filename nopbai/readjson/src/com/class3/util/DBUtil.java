package com.class3.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getMySQlConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/jsonAPI"
                            ,"sql","@Quoct2210m");
            return connection;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
