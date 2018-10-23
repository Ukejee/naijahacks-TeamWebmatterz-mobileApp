package com.example.ukeje.learnapplication;

public class Tutor {

    private String name;
    private String location;
    private String subjects;
    private String email, gender, experience, classLevel, password, briefDetails;


    public Tutor(String name, String location, String subjects,String email
                ,String gender, String experience, String classLevel, String password
                ,String briefDetails) {
        this.name = name;
        this.location = location;
        this.subjects = subjects;
        this.email  = email;
        this.gender = gender;
        this.experience = experience;
        this.classLevel = classLevel;
        this.password = password;
        this.briefDetails = briefDetails;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBriefDetails() {
        return briefDetails;
    }

    public void setBriefDetails(String briefDetails) {
        this.briefDetails = briefDetails;
    }
}
