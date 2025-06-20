package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HobbyTest {
    private Hobby testHobbie;

    @BeforeEach
    void runBefore() {
        testHobbie = new Hobby("Hicking");
    }

    @Test
    void testConstructor() {
        assertEquals("Hicking", testHobbie.getTittle());
    }

    @Test
    void testGetTittle() {
        assertEquals("Hicking", testHobbie.getTittle());
    }

    @Test
    void testSetTittle() {
        assertEquals("Hicking", testHobbie.getTittle());
        testHobbie.setTittle("Running");
        assertEquals("Running", testHobbie.getTittle());
    }

}
