package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {
    private Rental rental;
    private Car car;
    private Human human;

    @BeforeEach
    public void setUp() {
        car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
        human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
        rental = new Rental(human, car, 5, 50000);
    }

    @Test
    public void getCheckInDateTest() {
        assertEquals("Rented", rental.getCheckInDate());
    }

    @Test
    public void getCarTest() {
        assertEquals(car, rental.getCar());
    }

    @Test
    public void getHumanTest() {
        assertEquals(human, rental.getHuman());
    }

    @Test
    public void getDaysTest() {
        assertEquals(5, rental.getDays());
    }

    @Test
    public void getPriceTest() {
        assertEquals(50000, rental.getPrice());
    }

    @Test
    public void setCheckInDateTest() {
        rental.setCheckInDate(LocalDate.now());
        assertEquals("Checked in : " + LocalDate.now().toString(), rental.getCheckInDate());
    }
}
