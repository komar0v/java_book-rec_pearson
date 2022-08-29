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
public class M_MAE {
    int book_id;
    double book_rating_real;
    double book_rating_prediction;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public double getBook_rating_real() {
        return book_rating_real;
    }

    public void setBook_rating_real(double book_rating_real) {
        this.book_rating_real = book_rating_real;
    }

    public double getBook_rating_prediction() {
        return book_rating_prediction;
    }

    public void setBook_rating_prediction(double book_rating_prediction) {
        this.book_rating_prediction = book_rating_prediction;
    }

    public M_MAE() {
    }
    
    @Override
    public String toString() {
        return this.getBook_id()+","+this.getBook_rating_real()+","+this.getBook_rating_prediction();
    }
}
