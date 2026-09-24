package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class jdbcDemo {

    public static void main(String[] args) {

        String url = "jdbc:h2:~/test";
        String username = "rce";
        String password = "rce";

        try {
            Connection con =
                DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            // 2. Create Statement
            Statement stmt = con.createStatement();

            // 3. Execute SELECT query
            String sql = "SELECT * FROM STUDENT ";

            ResultSet rs = stmt.executeQuery(sql);

            // 4. Read data from ResultSet
            while (rs.next()) {

                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                int marks = rs.getInt("MARKS");

                System.out.println(
                        id + " | " + name + " | " + marks
                );
            }
            
          String sqlins = "INSERT INTO student VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sqlins);
            ps.setInt(1, 4638);
            ps.setString(2, "kailash");
            ps.setInt(3, 100);
            ps.executeUpdate(); 

            // 5. Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
