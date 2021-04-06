package com.example.p_app;

public class Person {

    int Image;
    String Name;
    String Presences;
    String Pending;

    public Person(int image, String name, String presences, String pending) {
        Image = image;
        Name = name;
        Presences = presences;
        Pending = pending;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPresences() {
        return Presences;
    }

    public void setPresences(String presences) {
        Presences = presences;
    }

    public String getPending() {
        return Pending;
    }

    public void setPending(String pending) {
        Pending = pending;
    }

}
