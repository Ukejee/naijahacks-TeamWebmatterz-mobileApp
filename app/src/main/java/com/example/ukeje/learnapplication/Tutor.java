package com.example.ukeje.learnapplication;

public class Tutor {

    private String name;
    private String location;
    private String subjects;


    public Tutor(String name, String location, String subjects) {
        this.name = name;
        this.location = location;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
