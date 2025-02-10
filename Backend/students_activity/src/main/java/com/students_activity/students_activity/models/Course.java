package com.students_activity.students_activity.models;

public class Course {
    //Atributos
    private int id;
    private String name;
    private int classes;

    //Métodos Contrutores
    public Course(int id, String name, int classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
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

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    
}
