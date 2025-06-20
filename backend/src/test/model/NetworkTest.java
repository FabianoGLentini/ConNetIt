package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class NetworkTest {
    private Network testNetwork;
    private Network testNetwork2;
    private List<Connection> twoConnectionsList;
    private Connection con01;
    private Connection con02;
    private Connection con03;

    @BeforeEach
    void runBefore() {
        testNetwork2 = new Network("test2");
        testNetwork = new Network("test1");

        con01 = new Connection("John", "He/Him", "Atomic", "Animator",
                "Friendly neighberhood animator! loves to draw.");
        con02 = new Connection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                "Friendly and hilghly active. met at bouldering gym");
        con03 = new Connection("Iris", "She/Her", "Brown Bag", "Animator", "");

        twoConnectionsList = new ArrayList<>();
        twoConnectionsList.add(con01);
        twoConnectionsList.add(con02);

        testNetwork2.setConnections(twoConnectionsList);
        testNetwork2.setnumOfConnections(2);
    }

    /* -----Simple Getter Method Testing----- */

    @Test
    void testeConstructor() {
        assertEquals(0, testNetwork.getConnectionNum());
        assertTrue(testNetwork.getConnections().isEmpty());

    }

    @Test
    void testGetConnections() {
        assertEquals(twoConnectionsList, testNetwork2.getConnections());
        testNetwork2 = new Network("test2");
        assertTrue(testNetwork2.getConnections().isEmpty());
    }

    @Test
    void testGetConnection() {
        assertEquals(con01, testNetwork2.getConnection("John"));
        assertEquals(con02, testNetwork2.getConnection("Iris"));
        assertEquals(null, testNetwork2.getConnection("Who"));
        testNetwork2.addConnection(con03);
        assertEquals(3, testNetwork2.getConnectionNum());
        assertEquals(con02, testNetwork2.getConnection("Iris"));

    }

    @Test
    void testGetConnectionCount() {
        assertEquals(2, testNetwork2.getConnectionNum());
        testNetwork2.addConnection(con03);
        assertEquals(3, testNetwork2.getConnectionNum());
        testNetwork2.removeConnection(con01);
        assertEquals(2, testNetwork2.getConnectionNum());

    }

    /* -----Simple Setter & Adder Method Testing----- */

    @Test
    void testSetConnections() {
        testNetwork.setConnections(twoConnectionsList);
        assertEquals(twoConnectionsList, testNetwork.getConnections());
    }

    @Test
    void testSetnumOfConnections() {
        assertEquals(0, testNetwork.getConnectionNum());
        testNetwork.setnumOfConnections(3);
        assertEquals(3, testNetwork.getConnectionNum());
    }

    @Test
    void testAddConnection() {
        testNetwork2.addConnection(con03);
        assertEquals(3, testNetwork2.getConnections().size());
        assertEquals(3, testNetwork2.getConnectionNum());
        assertEquals(twoConnectionsList, testNetwork2.getConnections());
    }

    /* -----Other To Be Labeled Tests----- */

    @Test
    void testRemoveConnection() {
        testNetwork2.removeConnection(con01);
        twoConnectionsList.remove(0);

        assertEquals(twoConnectionsList, testNetwork2.getConnections());
        assertEquals(1, testNetwork2.getConnectionNum());

    }

    @Test
    void testInList() {
        assertTrue(testNetwork2.inList(con01));
        assertFalse(testNetwork2.inList(con03));
        assertTrue(testNetwork2.inList(con02));
    }

}
