package org.example.Model;

import javafx.scene.control.Button;

public class StudentV2 {
    private int id;
    private String full_name;
    private String email;
    private String classe;

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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public StudentV2(int id,String full_name, String email, String classe) {
        this.full_name = full_name;
        this.email = email;
        this.classe = classe;
        this.id = id ;
    }

    public StudentV2() {
    }
}
