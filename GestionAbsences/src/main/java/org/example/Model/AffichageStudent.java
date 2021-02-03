package org.example.Model;

public class AffichageStudent {
    private  int id;
 private String full_name;
    private String type_ab;



    public AffichageStudent() {
    }

    public AffichageStudent(int id, String full_name, String type_ab) {
        this.id = id;
        this.full_name = full_name;
        this.type_ab = type_ab;
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

    public String getType_ab() {
        return type_ab;
    }

    public void setType_ab(String type_ab) {
        this.type_ab = type_ab;
    }
}
