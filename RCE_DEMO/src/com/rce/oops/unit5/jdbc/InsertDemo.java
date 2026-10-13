package com.rce.oops.unit5.jdbc;
import java.sql.*;
// Program 52: INSERT using PreparedStatement (placeholders prevent SQL injection)
public class InsertDemo {
    public static void main(String[] a) throws Exception {
        String url = "jdbc:mysql://localhost:3306/college";
        String sql = "INSERT INTO student VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url, "user", "password");
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, 101);
            ps.setString(2, "Ravi");
            int rows = ps.executeUpdate();
            System.out.println(rows + " row inserted");
        }
    }
}
