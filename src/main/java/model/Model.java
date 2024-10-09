package model;

import java.util.ArrayList;

public class Model {
    private ArrayList<Human> humans;
    private ArrayList<Car> cars;
    private ArrayList<Rental> rentals;

    public Model() {
        humans = new ArrayList<>();
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
    }
}
