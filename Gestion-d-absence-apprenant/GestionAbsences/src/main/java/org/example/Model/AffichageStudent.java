package org.example.Model;

public class AffichageStudent {
 private String full_name;
    private String type_ab;



    public AffichageStudent() {
    }

    public AffichageStudent(String full_name, String type_ab) {
        this.full_name = full_name;
        this.type_ab = type_ab;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getType_ab() {
        return type_ab;
    }

    public void setType_ab(String type_ab) {
        this.type_ab = type_ab;
    }
}
