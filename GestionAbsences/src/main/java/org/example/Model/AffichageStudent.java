package org.example.Model;

public class AffichageStudent {
 private String full_name;

 public AffichageStudent(){

 }

    public AffichageStudent(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
