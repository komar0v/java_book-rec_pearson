/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER_;

import MODEL_.M_User;
import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author frans
 */
public class C_User {
    M_User mUser = new M_User();
    
    public M_User getDetailUser(int userID) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "SELECT * FROM tabel_user WHERE user_id='" + userID + "'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            mUser.setUser_id(Integer.parseInt(rs.getString("user_id")));
            mUser.setUser_age(Integer.parseInt(rs.getString("user_age")));
            mUser.setUser_loc(rs.getString("user_loc"));
        }

        stmt.close();
        konek.close();
        return mUser;
    }
    
    public void save_EditUser(M_User data) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "UPDATE tabel_user SET "
                + "user_loc = '" + data.getUser_loc()+ "', "
                + "user_age = '"+ data.getUser_age()+"'"
                + "WHERE user_id = '" + data.getUser_id()+ "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
    public void hapus_User(int userID) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "DELETE FROM tabel_user WHERE user_id='" + userID + "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
    public void tambah_User(M_User datauser) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "INSERT INTO tabel_user SET "+
                "user_id='" + datauser.getUser_id()+ "',"+
                "user_age='"+datauser.getUser_age()+"',"+
                "user_loc='"+datauser.getUser_loc()+"'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
}
