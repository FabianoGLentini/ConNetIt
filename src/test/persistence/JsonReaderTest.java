package persistence;

import model.Connection;
import model.Network;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: code pulled, used or inspired from JsonSerialization
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchle.json");
        try {
            Network n = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyNetwork() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyNetwork.json");
        try {
            Network n = reader.read();
            assertEquals("My network", n.getName());
            assertEquals(0, n.getConnectionNum());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderSingleNetworkConnections() {
        JsonReader reader = new JsonReader("./data/testReaderSingleNetwork.json");
        try {
            Network n = reader.read();
            List<Connection> connections = n.getConnections();
            assertEquals("My network", n.getName());
            assertEquals(1, n.getConnectionNum());
            checkConnection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                    "Friendly and hilghly active. met at bouldering gym", connections.get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralNetwork() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralNetwork.json");
        try {
            Network n = reader.read();
            assertEquals("My work room", n.getName());
            List<Connection> connections = n.getConnections();

            assertEquals(2, connections.size());
            checkConnection("John", "He/Him", "Atomic", "Animator",
                    "Friendly neighberhood animator! loves to draw.", connections.get(0));
            checkConnection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                    "Friendly and hilghly active. met at bouldering gym", connections.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
