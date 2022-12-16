package com.cybertools.collegeCBDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class collegeCBDD {
	 
    private static Connection conn;
    
    static {
        String url = "jdbc:mysql://localhost/college?useSSL=false";
        String user = "root";
        String password = "2003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }

}