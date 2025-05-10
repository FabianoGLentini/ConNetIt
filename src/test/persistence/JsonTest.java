package persistence;

import model.Connection;

import model.ConnectionField;

import static org.junit.jupiter.api.Assertions.assertEquals;

// CITATION: code pulled, used or inspired from JsonSerialization
public class JsonTest {

    protected void checkConnection(String name, String pronouns, String company, String jobTittle, String description,
            Connection connection) {
        assertEquals(name, connection.getField(ConnectionField.NAME));
        assertEquals(pronouns, connection.getField(ConnectionField.PRONOUNS));
        assertEquals(company, connection.getField(ConnectionField.COMPANY));
        assertEquals(jobTittle, connection.getField(ConnectionField.JOBTITLE));
        assertEquals(description, connection.getField(ConnectionField.DESCRIPTION));

    }
}
