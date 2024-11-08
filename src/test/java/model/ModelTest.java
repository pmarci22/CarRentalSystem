package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
        model.addCar(car);
        assertEquals(1, model.getCars().size());
    }

    @Test
    public void testRemoveCar() {
        Car car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
        model.addCar(car);
        model.removeCar(car);
        assertEquals(0, model.getCars().size());
    }

    @Test
    public void testAddHuman() {
        Human human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
        model.addHuman(human);
        assertEquals(1, model.getHumans().size());
    }

    @Test
    public void testRemoveHuman() {
        Human human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
        model.addHuman(human);
        model.removeHuman(human);
        assertEquals(0, model.getHumans().size());
    }

    @Test
    public void testAddRental() {
        Car car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
        Human human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
        Rental rental = new Rental(human, car, 5, 50000);
        model.addRental(rental);
        assertEquals(1, model.getRentals().size());
    }

    @Test
    public void testRemoveRental() {
        Car car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
        Human human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
        Rental rental = new Rental(human, car, 5, 50000);
        model.addRental(rental);
        model.removeRental(rental);
        assertEquals(0, model.getRentals().size());
    }
}
