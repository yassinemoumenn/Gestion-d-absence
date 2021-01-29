package org.example.Model;

import java.sql.Date;

public class Absences {

    private int id, Student_id;
    private Date date;
    private String Absence_type;

    public Absences() {
    }

    public Absences(int id, int student_id, Date date, String absence_type) {
        this.id = id;
        Student_id = student_id;
        this.date = date;
        Absence_type = absence_type;
    }

    public Absences(Date date, String absence_type) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAbsence_type() {
        return Absence_type;
    }

    public void setAbsence_type(String absence_type) {
        Absence_type = absence_type;
    }


}
