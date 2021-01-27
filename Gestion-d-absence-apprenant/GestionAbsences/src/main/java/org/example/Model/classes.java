package org.example.Model;

public class classes {
    private int id;

    private String classe;

    public classes(int id, String classe) {
        this.id = id;
        this.classe = classe;
    }

    public classes(String classe) {
        this.classe = classe;
    }

    public classes() {
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
