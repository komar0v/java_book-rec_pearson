/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER_;

import MODEL_.M_Ratings;
import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author frans
 */
public class C_Ratings {

    M_Ratings rating = new M_Ratings();

    public void tambah_Rating(M_Ratings dataRating) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "INSERT INTO tabel_rating SET "
                + "user_id='" + dataRating.getUser_id() + "',"
                + "book_rating='" + dataRating.getBook_rating() + "',"
                + "book_id=(SELECT _id FROM tabel_buku WHERE book_isbn='"+ dataRating.getBook_isbn() +"'),"
                + "book_isbn='" + dataRating.getBook_isbn() + "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }

    public M_Ratings getDetailRating(int userID, String book_isbn) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "SELECT tabel_buku.book_title, tabel_rating.user_id, tabel_rating.book_isbn, tabel_rating.book_rating "
                + "FROM tabel_rating "
                + "JOIN tabel_buku ON tabel_buku.book_isbn=tabel_rating.book_isbn "
                + "WHERE tabel_buku.book_isbn='"+book_isbn+"' AND tabel_rating.user_id="+userID;
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            rating.setUser_id(Integer.parseInt(rs.getString("user_id")));
            rating.setBook_isbn(rs.getString("book_isbn"));
            rating.setBook_rating(Double.parseDouble(rs.getString("book_rating")));
        }

        stmt.close();
        konek.close();
        return rating;
    }

    public void save_EditRating(M_Ratings data) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "UPDATE tabel_rating SET "
                + "book_rating = '" + data.getBook_rating() + "'"
                + "WHERE user_id = '" + data.getUser_id() + "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
    public void hapus_Rating(String ISBN, int user_id) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "DELETE FROM tabel_rating WHERE book_isbn='" + ISBN + "' AND user_id="+user_id;
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
    public Double getAverageRating(String book_isbn) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "SELECT AVG(book_rating) AS average_rating FROM tabel_rating WHERE book_isbn='"+book_isbn+"'";
        ResultSet rs = stmt.executeQuery(query);
        Double avg_rating=0.0;
        while (rs.next()) {
            avg_rating = rs.getDouble("average_rating");
        }

        stmt.close();
        konek.close();
        return avg_rating;
    }
}
