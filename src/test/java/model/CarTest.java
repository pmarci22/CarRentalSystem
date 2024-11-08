package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Toyota", "Corolla", 2015, "Yellow", 10000);
    }

    @Test
    public void getterTests() {
        assertEquals("Toyota", car.getMake());
        assertEquals("Corolla", car.getModel());
        assertEquals(2015, car.getYear());
        assertEquals("Yellow", car.getColor());
        assertEquals(10000, car.getPrice());
    }

    @Test
    public void setterTests() {
        car.setMake("Ford");
        car.setModel("Focus");
        car.setYear(2016);
        car.setColor("Red");
        car.setPrice(20000);
        assertEquals("Ford", car.getMake());
        assertEquals("Focus", car.getModel());
        assertEquals(2016, car.getYear());
        assertEquals("Red", car.getColor());
        assertEquals(20000, car.getPrice());
    }

}
