package model;

public class Rental {
    private Human human;
    private Car car;
    private int days;

    Rental(Human human, Car car, int days) {
        this.human = human;
        this.car = car;
        this.days = days;
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
}
