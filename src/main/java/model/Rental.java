package model;

public class Rental {
    private Human human;
    private Car car;
    private int days;
    private int price;

    public Rental(Human human, Car car, int days, int price) {
        this.human = human;
        this.car = car;
        this.days = days;
        this.price = price;
    }

    // Getters

    public Human getHuman() {
        return human;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public int getPrice() {
        return price;
    }

    // Setters

    public void setHuman(Human human) {
        this.human = human;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
