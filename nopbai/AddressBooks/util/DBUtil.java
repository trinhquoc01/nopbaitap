package AddressBooks.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AddressBook", "sa", "@Quoct2210m");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return conn;
    }
}
