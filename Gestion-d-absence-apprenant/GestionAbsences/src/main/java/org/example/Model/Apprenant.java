package org.example.Model;

public class Apprenant {
    private int id;
    private int user_id;
    private int class_id;


<<<<<<< HEAD:Gestion-d-absence-apprenant/GestionAbsences/src/main/java/org/example/Model/Apprenant.java
=======
    public Apprenant() {
    }

    public Apprenant(int id, int user_id, int class_id) {
        this.id = id;
        this.user_id = user_id;
        this.class_id = class_id;

    }

    public Apprenant(int user_id, int class_id) {
        this.user_id = user_id;
        this.class_id = class_id;
    }

>>>>>>> administrateur:GestionAbsences/src/main/java/org/example/Model/Apprenant.java
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


    public Apprenant(int id, int user_id, int class_id, int speciality_id) {
        this.id = id;
        this.user_id = user_id;
        this.class_id = class_id;
        this.speciality_id = speciality_id;
    }
}


