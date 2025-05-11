package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionTest {
    private Connection testConnection;

    @BeforeEach
    void runBefore() {

        testConnection = new Connection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                "Friendly and hilghly active. met at bouldering gym");
    }

    @Test
    void testConstructor() {
        testConnection = new Connection("John", "He/Him", "Atomic", "Animator",
                "Friendly neighberhood animator! loves to draw.");

        assertEquals("John", testConnection.getField(ConnectionField.NAME));
        assertEquals("He/Him", testConnection.getField(ConnectionField.PRONOUNS));
        assertEquals("Atomic", testConnection.getField(ConnectionField.COMPANY));
        assertEquals("Animator", testConnection.getField(ConnectionField.JOBTITLE));
        assertEquals("Friendly neighberhood animator! loves to draw.",
                testConnection.getField(ConnectionField.DESCRIPTION));

    }

    /* -----Simple Getter Method Testing----- */

    void testGetName() {
        assertEquals("Iris", testConnection.getField(ConnectionField.NAME));
    }

    @Test
    void testGetPronouns() {
        assertEquals("They/Them", testConnection.getField(ConnectionField.PRONOUNS));

    }

    @Test
    void testGetCompany() {
        assertEquals("Boulderz", testConnection.getField(ConnectionField.COMPANY));

    }

    @Test
    void testGetJobTittle() {
        assertEquals("Bouldering Athlete", testConnection.getField(ConnectionField.JOBTITLE));

    }

    @Test
    void testGetDescription() {
        assertEquals("Friendly and hilghly active. met at bouldering gym",
                testConnection.getField(ConnectionField.DESCRIPTION));

    }

    /* ----- Simple Setter Method Testing----- */

    @Test
    void testSetName() {
        assertEquals("Iris", testConnection.getField(ConnectionField.NAME));
        testConnection.setField(ConnectionField.NAME, "Vic");
        assertEquals("Vic", testConnection.getField(ConnectionField.NAME));

    }

    @Test
    void testSetPronouns() {
        assertEquals("They/Them", testConnection.getField(ConnectionField.PRONOUNS));
        testConnection.setField(ConnectionField.PRONOUNS, "He/Him");
        assertEquals("He/Him", testConnection.getField(ConnectionField.PRONOUNS));

    }

    @Test
    void testSetCompany() {
        assertEquals("Boulderz", testConnection.getField(ConnectionField.COMPANY));
        testConnection.setField(ConnectionField.COMPANY, "Skate It Canada");
        assertEquals("Skate It Canada", testConnection.getField(ConnectionField.COMPANY));

    }

    @Test
    void testSetJobTittle() {
        assertEquals("Bouldering Athlete", testConnection.getField(ConnectionField.JOBTITLE));
        testConnection.setField(ConnectionField.JOBTITLE, "Figure Skater");
        assertEquals("Figure Skater", testConnection.getField(ConnectionField.JOBTITLE));

    }

    @Test
    void testSetDescription() {
        assertEquals("Friendly and hilghly active. met at bouldering gym",
                testConnection.getField(ConnectionField.DESCRIPTION));
        testConnection.setField(ConnectionField.DESCRIPTION,
                "Friendly and hilghly active. met at bouldering gym! Also draws commics.");
        assertEquals("Friendly and hilghly active. met at bouldering gym! Also draws commics.",
                testConnection.getField(ConnectionField.DESCRIPTION));

    }

}
