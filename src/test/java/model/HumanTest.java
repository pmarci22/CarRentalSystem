package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    private Human human;

    @BeforeEach
    public void setUp() {
        human = new Human("Kun Béla", 21, 58932, "Budaörs Kis köz 3", "06301234567");
    }

    @Test
    public void getterTests() {
        assertEquals("Kun Béla", human.getName());
        assertEquals(21, human.getAge());
        assertEquals(58932, human.getIdnumber());
        assertEquals("Budaörs Kis köz 3", human.getAddress());
        assertEquals("06301234567", human.getPhoneNumber());
    }

    @Test
    public void setterTests() {
        human.setName("Kiss Béla");
        human.setAge(50);
        human.setIdnumber(58633);
        human.setAddress("Törökbálint Nagy utca 41");
        human.setPhoneNumber("06301985674");
        assertEquals("Kiss Béla", human.getName());
        assertEquals(50, human.getAge());
        assertEquals(58633, human.getIdnumber());
        assertEquals("Törökbálint Nagy utca 41", human.getAddress());
        assertEquals("06301985674", human.getPhoneNumber());
    }
}
