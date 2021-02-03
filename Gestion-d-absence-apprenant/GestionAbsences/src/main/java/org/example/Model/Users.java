package org.example.Model;

public class Users {

    private int id;
    private String full_name;
    private String email;
    private String password;

    public Users(String full_name, String email, String password, String type) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public Users(int id_user, String full_name, String email, String password, String type) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


}
