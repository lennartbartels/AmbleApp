package amble.model;

import android.app.Activity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hintzl on 05.10.2017.
 */

public class User{
    private String username ;
    private String firstname;
    private String lastname;
    private String emailadress;
    private String password;

    public User(String username, String firstname, String lastname, String emailadress, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailadress = emailadress;
        this.password = password;
    }




    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailadress='" + emailadress + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }
}