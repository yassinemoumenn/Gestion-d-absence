package org.example.Model;

public class Formateur extends Users {

    private int id_formateur;
    private int user_id;
    private int class_id;

    public Formateur(){

    }

    public Formateur(String full_name, String email, String password, String type, int id_formateur, int user_id, int class_id) {
        super(full_name, email, password, type);
        this.id_formateur = id_formateur;
        this.user_id = user_id;
        this.class_id = class_id;
    }

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}