package amble.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hintzl on 05.10.2017.
 */

public class User {

    @SerializedName("id")
    private Integer id;
    @SerializedName("username")
    private String username;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("emailadress")
    private String emailaddress;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("password")
    private String password;

    public User(String username, String lastname, String emailaddress, String firstname, String password) {
        this.username = username;
        this.lastname = lastname;
        this.emailaddress = emailaddress;
        this.firstname = firstname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;

    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }
}
