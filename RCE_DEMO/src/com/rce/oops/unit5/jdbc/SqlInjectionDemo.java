package com.rce.oops.unit5.jdbc;
// Program 53: SQL injection - needs NO database, just shows the difference in the SQL text
public class SqlInjectionDemo {
    public static void main(String[] args) {
        String userInput = "x' OR '1'='1";
        // Statement style: input is joined as text -> attacker changes the query
        String bad = "SELECT * FROM users WHERE name = '" + userInput + "'";
        System.out.println("Statement built  : " + bad);
        // PreparedStatement style: SQL has a ? placeholder, input is sent separately as data
        String good = "SELECT * FROM users WHERE name = ?";
        System.out.println("Prepared SQL     : " + good + "   [?] = " + userInput + "  (treated as plain data)");
    }
}
