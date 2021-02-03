package org.example.Model;

import java.util.Date;

public class Absences {
    private int id ;
    private int Student_id;
    private String date;
    private int Absence_type;
    private String Absence_typ;

    public String getAbsence_typ() {
        return Absence_typ;
    }

    public void setAbsence_typ(String absence_typ) {
        Absence_typ = absence_typ;
    }

    public Absences(String date, String absence_typ) {
        this.date = date;
        Absence_typ = absence_typ;
    }

    public Absences( int id, int student_id, String date, int absence_type) {
        this.id = id;
        Student_id = student_id;
        this.date = date;
        Absence_type = absence_type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAbsence_type() {
        return Absence_type;
    }

    public void setAbsence_type(int absence_type) {
        Absence_type = absence_type;
    }


}
