package model;

import java.io.Serializable;

public class Human implements Serializable {
    private String name;
    private int age;
    private int idnumber;
    private String address;
    private String phoneNumber;

    public Human(String name, int age, int idnumber, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.idnumber = idnumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return "Name: " + name + " Age: " + age + " ID Number: " + idnumber;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
