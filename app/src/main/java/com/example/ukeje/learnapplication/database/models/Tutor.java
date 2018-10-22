package com.example.ukeje.learnapplication.database.models;

public class Tutor {

    public static final String TABLE_NAME = "tutors";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_SUBJECT = "subject";

    private int id;
    private String name;
    private String subject;
    private String location;


    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_LOCATION + " TEXT, "
                    + COLUMN_SUBJECT + " TEXT " + ")";


    public Tutor() {
    }

    public Tutor(int id, String name, String subject, String location) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.location = location;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }
}
