package com.adrianl.adrianfxml.model;

public class Persona {

    public String picture;
    public String name;
    public String gender;
    public String location;
    public String email;
    public String phone;

    public Persona(String picture, String name, String gender, String location, String email, String phone) {
        this.picture = picture;
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.email = email;
        this.phone = phone;
    }

    public String getPicture() {return picture;}
    public void setPicture(String picture) {this.picture = picture;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    @Override
    public String toString() {return name;}

}
