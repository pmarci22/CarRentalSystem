package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model implements Serializable {
    private ArrayList<Human> humans;
    private ArrayList<Car> cars;
    private ArrayList<Rental> rentals;

    public Model() {
        humans = new ArrayList<>();
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // Adders

    public void addHuman(Human human){
        humans.add(human);
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addRental(Rental rental){
        rentals.add(rental);
    }

    // Removers

    public void removeHuman(Human human){
        humans.remove(human);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
    }

    // Getters

    public List<Human> getHumans() {
        return humans;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
