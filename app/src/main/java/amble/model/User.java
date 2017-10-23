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
    private String emailaddress;
    private String password;

    public User(String username, String firstname, String lastname, String emailaddress, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.password = password;
    }




    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailadress='" + emailaddress + '\'' +
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailadress) {
        this.emailaddress = emailadress;
    }

    public String getPassword(){ return password;}

    public void setPassword(String password) { this.password = password;}
}