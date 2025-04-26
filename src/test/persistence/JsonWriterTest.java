package persistence;

import model.Network;
import model.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// CITATION: code pulled, used or inspired from JsonSerialization
public class JsonWriterTest extends JsonTest {
    private Connection con01;
    private Connection con02;

    @BeforeEach
    void runBefore() {
        con01 = new Connection("John", "He/Him", "Atomic", "Animator",
                "Friendly neighberhood animator! loves to draw.");
        con02 = new Connection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                "Friendly and hilghly active. met at bouldering gym");
    }

    @Test
    void testWriterInvalidFile() {
        try {
            Network n = new Network("My network");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyNetwork() {
        try {
            Network n = new Network("My network");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyNetwork.json");
            writer.open();
            writer.write(n);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyNetwork.json");
            n = reader.read();
            assertEquals("My network", n.getName());
            assertEquals(0, n.getConnectionNum());

            reader = new JsonReader("./data/fail.json");
            
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterSingleNetwork() {
        try {
            Network n = new Network("some");
            JsonWriter writer = new JsonWriter("./data/testWriterSingleNetwork.json");
            writer.open();
            writer.write(n);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterSingleNetwork.json");
            n = reader.read();
            assertEquals("some", n.getName());
            assertEquals(0, n.getConnectionNum());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralNetwork() {
        try {
            Network n = new Network("My network");
            n.addConnection(con01);
            n.addConnection(con02);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralNetwork.json");
            writer.open();
            writer.write(n);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralNetwork.json");
            n = reader.read();
            assertEquals("My network", n.getName());
            List<Connection> connections = n.getConnections();
            assertEquals(2, connections.size());
            checkConnection("John", "He/Him", "Atomic", "Animator",
                    "Friendly neighberhood animator! loves to draw.", connections.get(0));
            checkConnection("Iris", "They/Them", "Boulderz", "Bouldering Athlete",
                    "Friendly and hilghly active. met at bouldering gym", connections.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
