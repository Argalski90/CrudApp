package com.argalski.entity;

public class User {

    private long id;

    private String name;

    private String course;

    public User() { }

    public User(long id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
