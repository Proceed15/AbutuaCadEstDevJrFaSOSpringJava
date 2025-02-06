package com.students_activity.students_activity.models;

public class Course {
    //Atributos
    private int id;
    private String name;
    private int period;

    //Métodos Contrutores
    public Course(int id, String name, int period) {
        this.id = id;
        this.name = name;
        this.period = period;
    }

    public Course(){
        //Método Acessível Agora
    }

    //Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
