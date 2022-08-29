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
public class M_Recommender {

    int user_id, book_id;
    double pearson_value;

    public M_Recommender() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public double getPearson_value() {
        return pearson_value;
    }

    public void setPearson_value(double pearson_value) {
        this.pearson_value = pearson_value;
    }

    @Override
    public String toString() {
        return this.getUser_id()+","+this.getBook_id()+","+"="+this.getPearson_value();
    }

}
