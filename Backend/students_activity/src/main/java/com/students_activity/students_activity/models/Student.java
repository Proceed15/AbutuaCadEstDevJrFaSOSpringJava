package com.students_activity.students_activity.models;

public class Student {
    //Declaração dos Atributos
    private int id;
    private String name;
    private String phone;
    private String email;
    private int idCourse;
    private int period;

    //Métodos Construtores
    public Student (int id, String name, String phone, String email, int idCourse, int period){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.idCourse = idCourse;
        this.period = period;
    }

    public Student (){
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }
    public int getPeriod() {
        return period;
    }
    public void setPeriod(int period) {
        this.period = period;
    } 
}
