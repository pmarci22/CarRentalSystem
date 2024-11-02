package presenter;

import model.Car;
import model.Human;
import model.Model;
import model.Rental;
import view.View;

import java.io.Serializable;
import java.util.List;

public class Presenter implements Serializable {
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

    public List<Human> getHumanList() {
        return model.getHumans();
    }

    public void addHuman(Human human) {
        model.addHuman(human);
    }

    public List<Rental> getRentalList() {
        return model.getRentals();
    }

    public void addRental(Rental rental) {
        model.addRental(rental);
    }
}
