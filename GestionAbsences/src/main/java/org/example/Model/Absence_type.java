package org.example.Model;

public class Absence_type {
    int id;
    String type_ab;

    public Absence_type(String string) {
    }

    public Absence_type(int id, String type_ab) {
        this.id = id;
        this.type_ab = type_ab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_ab() {
        return type_ab;
    }

    public void setType_ab(String type_ab) {
        this.type_ab = type_ab;
    }
}
