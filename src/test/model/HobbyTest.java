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
        assertEquals("Hicking", testHobbie.getTitle());
    }

    @Test
    void testGetTittle() {
        assertEquals("Hicking", testHobbie.getTitle());
    }

    @Test
    void testSetTittle() {
        assertEquals("Hicking", testHobbie.getTitle());
        testHobbie.setTitle("Running");
        assertEquals("Running", testHobbie.getTitle());
    }

}
