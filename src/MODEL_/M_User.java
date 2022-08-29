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
public class M_User {
    int user_id, user_age;
    String user_loc;

    public M_User(int user_id, int user_age, String user_loc) {
        this.user_id = user_id;
        this.user_age = user_age;
        this.user_loc = user_loc;
    }

    public M_User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_loc() {
        return user_loc;
    }

    public void setUser_loc(String user_loc) {
        this.user_loc = user_loc;
    }
    
    
}
