package com.argalski.Entity;

public class User {

    private int id;
    private String name;
    private String course;

    public User(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public User() { }

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
