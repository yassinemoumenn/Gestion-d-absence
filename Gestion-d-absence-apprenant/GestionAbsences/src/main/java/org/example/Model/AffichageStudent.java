package org.example.Model;

public class AffichageStudent {
 private String full_name;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    private int student_id;
    private String type_ab;



    public AffichageStudent() {
    }

    public AffichageStudent(String full_name, String type_ab, int student_id) {
        this.full_name = full_name;
        this.type_ab = type_ab;
        this.student_id = student_id;
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
