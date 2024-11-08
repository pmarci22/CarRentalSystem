package presenter;

import model.Car;
import model.Human;
import model.Model;
import model.Rental;
import serialization.SerializationUtility;
import view.View;

import java.io.Serializable;
import java.util.List;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void mainMenu() {
        view.showMainMenu();
    }

    public List<Car> getCarList() {
        return model.getCars();
    }

    public void addCar(Car car) {
        model.addCar(car);
    }

    public void removeCar(int n) {
        model.removeCar(model.getCars().get(n));
    }

    public List<Human> getHumanList() {
        return model.getHumans();
    }

    public void addHuman(Human human) {
        model.addHuman(human);
    }

    public void removeHuman(int n) {
        model.removeHuman(model.getHumans().get(n));
    }

    public List<Rental> getRentalList() {
        return model.getRentals();
    }

    public void addRental(Rental rental) {
        model.addRental(rental);
    }

    public void removeRental(int n) {
        model.removeRental(model.getRentals().get(n));
    }

    public void saveModel(String fileName) {
        try {
            SerializationUtility.serializeModel(model, fileName);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
