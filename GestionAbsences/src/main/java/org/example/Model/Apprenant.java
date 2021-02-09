package org.example.Model;

public class Apprenant {
    private int id;
    private int user_id;
    private int class_id;
    private int speciality_id;

    public Apprenant() {
    }

    public Apprenant(int id, int user_id, int class_id, int speciality_id) {
        this.id = id;
        this.user_id = user_id;
        this.class_id = class_id;
        this.speciality_id = speciality_id;
    }

    public Apprenant(int user_id, int class_id, int speciality_id) {
        this.user_id = user_id;
        this.class_id = class_id;
        this.speciality_id = speciality_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(int speciality_id) {
        this.speciality_id = speciality_id;
    }

}
