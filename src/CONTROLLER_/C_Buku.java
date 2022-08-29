/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER_;

import MODEL_.M_Buku;
import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author frans
 */
public class C_Buku {

    M_Buku mbuku = new M_Buku();

    public void save_EditBuku(M_Buku data) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "UPDATE tabel_buku SET "
                + "book_title = '" + data.getBook_title() + "', "
                + "book_author = '" + data.getBook_author() + "', "
                + "book_pub = '" + data.getBook_pub() + "',"
                + "year_of_pub = '" + data.getYear_of_pub() + "', "
                + "book_img_url = '" + data.getBook_img_url() + "' "
                + "WHERE book_isbn = '" + data.getBook_isbn() + "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }

    public M_Buku getDetailBuku(String ISBN) throws SQLException {
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "SELECT * FROM tabel_buku WHERE book_isbn='" + ISBN + "'";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            mbuku.setBook_isbn(rs.getString("book_isbn"));
            mbuku.setBook_title(rs.getString("book_title"));
            mbuku.setBook_author(rs.getString("book_author"));
            mbuku.setBook_pub(rs.getString("book_pub"));
            mbuku.setYear_of_pub(rs.getInt("year_of_pub"));
            mbuku.setBook_img_url(rs.getString("book_img_url"));
        }

        stmt.close();
        konek.close();
        return mbuku;
    }
    
    public void hapus_Buku(String ISBN) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "DELETE FROM tabel_buku WHERE book_isbn='" + ISBN + "'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
    public void tambah_Buku(M_Buku databuku) throws SQLException{
        connectorDb koneksi = new connectorDb();
        Connection konek = koneksi.getConnection();
        Statement stmt = konek.createStatement();
        String query = "INSERT INTO tabel_buku SET "+
                "book_isbn='" + databuku.getBook_isbn() + "',"+
                "book_title='"+databuku.getBook_title()+"',"+
                "book_author='"+databuku.getBook_author()+"',"+
                "book_pub='"+databuku.getBook_pub()+"',"+
                "year_of_pub='"+databuku.getYear_of_pub()+"',"+
                "book_img_url='"+databuku.getBook_img_url()+"'";
        stmt.executeUpdate(query);
        stmt.close();
        konek.close();
    }
    
}
