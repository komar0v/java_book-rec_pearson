/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_;

import java.sql.Connection;


/**
 *
 * @author frans
 */

public class M_Buku {
    private String book_isbn, book_title, book_author, book_pub, book_img_url;
    private int year_of_pub;

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_pub() {
        return book_pub;
    }

    public void setBook_pub(String book_pub) {
        this.book_pub = book_pub;
    }

    public String getBook_img_url() {
        return book_img_url;
    }

    public void setBook_img_url(String book_img_url) {
        this.book_img_url = book_img_url;
    }

    public int getYear_of_pub() {
        return year_of_pub;
    }

    public void setYear_of_pub(int year_of_pub) {
        this.year_of_pub = year_of_pub;
    }

    public M_Buku(String book_isbn, String book_title, String book_author, String book_pub, String book_img_url, int year_of_pub) {
        this.book_isbn = book_isbn;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pub = book_pub;
        this.book_img_url = book_img_url;
        this.year_of_pub = year_of_pub;
    }
    
    public M_Buku(){
        
    }

    
}
