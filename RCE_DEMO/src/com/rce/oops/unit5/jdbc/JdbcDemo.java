package com.rce.oops.unit5.jdbc;
import java.sql.*;
// Program 51: JDBC - SELECT with Statement (try-with-resources closes automatically)
// Needs: MySQL running + mysql-connector-j JAR added to Build Path (see README + college.sql)
public class JdbcDemo {
    public static void main(String[] a) throws Exception {
        String url = "jdbc:mysql://localhost:3306/college";
        try (Connection con = DriverManager.getConnection(url, "user", "password");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, name FROM student")) {
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
    }
}
