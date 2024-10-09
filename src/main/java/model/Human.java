package model;

public class Human {
    private String name;
    private int age;
    private int idnumber;
    private String address;
    private String phoneNumber;

    Human(String name, int age, int idnumber, String address, String phoneNumber) {
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

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIDnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
