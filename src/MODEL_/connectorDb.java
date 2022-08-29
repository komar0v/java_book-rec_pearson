/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author frans
 */
public class connectorDb {

    String host = "localhost";
    String user_id = "root";
    String pass = "";
    String port = "3306";
    String database = "sisrekom_buku_db";
    private static Connection conn;

    public Connection getConnection() {
        Connection result = null;
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            result = (Connection) DriverManager.getConnection(url, user_id, pass);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERR..  CONNECTION FAILED!\n" + e.getMessage());
            System.exit(0);
        }
        return result;
    }
    
    public static Connection getKoneksi() {
        Connection result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sisrekom_buku_db", "root", "");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERR..  CONNECTION FAILED!\n" + e.getMessage());
            System.exit(0);
        }
        return conn;
    }
    
    public Connection test_connection() {
        Connection result = null;
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            result = (Connection) DriverManager.getConnection(url, user_id, pass);
            System.out.println("DATABASE CONNECTED");
            JOptionPane.showMessageDialog(null, "CONNECTION SUCCESS");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERR..  CONNECTION FAILED!\n" + e.getMessage());
            System.exit(0);
        }
        return result;
    }
}
