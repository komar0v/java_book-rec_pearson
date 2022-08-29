/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL_;

/**
 *
 * @author frans
 */
public class M_Ratings {
    int user_id;
    String book_isbn;
    double book_rating;

    public M_Ratings() {
    }

    public M_Ratings(int user_id, String book_isbn, double book_rating) {
        this.user_id = user_id;
        this.book_isbn = book_isbn;
        this.book_rating = book_rating;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public double getBook_rating() {
        return book_rating;
    }

    public void setBook_rating(double book_rating) {
        this.book_rating = book_rating;
    }
    
    
}
