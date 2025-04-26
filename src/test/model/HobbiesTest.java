package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

public class HobbiesTest {
    private Hobbies testHobbies;
    private HashMap<String, Hobby> testHasMapList;
    private HashMap<String, Hobby> testHashMapListWithHobbies;
    private Hobbies testHobbiesWithHobbiesTracked;
    private Hobby running;
    private Hobby climbing;
    private Hobby skate;

    @BeforeEach
    void runBefore() {
        testHobbies = new Hobbies();
        testHobbiesWithHobbiesTracked = new Hobbies();
        testHasMapList = new HashMap<>();
        testHashMapListWithHobbies = new HashMap<>();

        running = new Hobby("Running");
        climbing = new Hobby("Climbing");
        skate = new Hobby("Skate");

        testHashMapListWithHobbies.put("running", running);
        testHashMapListWithHobbies.put("climbing", climbing);

        testHobbiesWithHobbiesTracked.setTrackedHobbies(testHashMapListWithHobbies);

    }

    @Test
    void testConstrucor() {
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());
    }

    @Test
    void testSetTrackedHobbies() {
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());
    }

    @Test
    void testGetTrackedHobbies() {
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());

    }

    @Test
    void testAddHobbieToTrack() {
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());
        testHobbies.addHobbieToTrack("Climbing", climbing);
        testHasMapList.put("climbing", climbing);
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());
        testHobbies.addHobbieToTrack("Climbing", climbing);
        assertEquals(1, testHobbies.getTrackedHobbies().size());
        testHobbies.addHobbieToTrack("Running", running);
        testHasMapList.put("running", running);
        assertEquals(testHasMapList, testHobbies.getTrackedHobbies());
    }

    @Test
    void testCreateNewHobby() {
        assertEquals("Skate", testHobbies.createNewHobby("Skate").getTittle());
        testHasMapList.put("skate", skate);
        assertEquals(1, testHobbies.getTrackedHobbies().size());
        testHobbies.createNewHobby("Climbing");
        testHasMapList.put("climb", climbing);
        assertEquals(2, testHobbies.getTrackedHobbies().size());

    }

    @Test
    void testExistingedHobby() {
        assertFalse(testHobbiesWithHobbiesTracked.existingHobby("Skate"));
        assertTrue(testHobbiesWithHobbiesTracked.existingHobby("Climbing"));
        assertTrue(testHobbiesWithHobbiesTracked.existingHobby("cLimBing"));

    }

    @Test
    void testGetHobbieFromTrack() {
        assertEquals(climbing, testHobbiesWithHobbiesTracked.getHobbyFromTrack("Climbing"));
    }

}
