package model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;

// A class representing the collection of Connections as a Network
public class Network implements Writable {
    private int numOfConnections;
    private List<Connection> connections;
    private String name;

    // TODO look up if network should be the center control holding all values of classes to manage and access? is that normal

    // TODO MUST FIND OUT how to set up account loading etc

    // TODO MUST FIND OUT mango db set up for loading and saving account

    // EFFECTS: creates Network, holds Connection List
    public Network(String name) {
        this.name = name;
        numOfConnections = 0; // TODO should I keep constant track of num con it or should it be at method?
        connections = new ArrayList<>();
    }

    // EFFECTS: return Connection from name if in connections else return null
    public Connection getConnection(String name) {
        List<Connection> listInstance = this.getConnections();

        for (Connection connection : listInstance) {
            if (name.equals(connection.getField(ConnectionField.NAME))) {
                return connection;
            }
        }

        return null;
    }

    // EFFECTS: return Network name
    public String getName() {
        return name;
    }

    // EFFECTS: return number of Connection in connectionList
    public int getConnectionNum() {
        return numOfConnections;
    }

    // EFFECTS: get connections list
    public List<Connection> getConnections() {
        // EventLog.getInstance()
        // .logEvent(new Event("Get list of connections from Network account"));

        return Collections.unmodifiableList(connections); // TODO why unmodifiable list ..?
    }

    // REQUIRES: !inList()
    // MODIFFIES: this
    // EFFECTS: add new connection to network
    public void addConnection(Connection connection) {
        EventLog.getInstance()
                .logEvent(new Event("Added " + connection.getField(ConnectionField.NAME) + " to network"));
        // TODO turn connection name into title case

        // TODO try catch of title case version of inlist..?

        connections.add(connection);
        numOfConnections += 1;

    }

    // REQUIRES: !inList()
    // MODIFFIES: this
    // EFFECTS: remove connection from network by removing from connections List
    public void removeConnection(Connection connection) {
        EventLog.getInstance()
                .logEvent(new Event("Removed " + connection.getField(ConnectionField.NAME) + " from network"));

        connections.remove(connection);
        numOfConnections -= 1;
    }

    // EFFECTS: return true if connection reference in connections list
    public boolean inList(Connection connection) {
        return connections.contains(connection);

    }

    /////////////////////////////////////////////////////////////

    /* ---------- Json saving methods for network ------------ */

    ////////////////////////////////////////////////////////////

    @Override
    // EFFECTS: create Json version of Connection class
    // For saving and loading purposes
    // CITATION: code pulled, used or inspired from JsonSerialization
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("numOfConnections", numOfConnections);
        json.put("connections", connectionsToJson());
        return json;
    }

    // EFFECTS: returns connections in this Network as a JSON array
    // CITATION: code pulled, used or inspired from JsonSerialization
    private JSONArray connectionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Connection connection : connections) {
            jsonArray.put(connection.toJson());
        }

        return jsonArray;
    }

    /////////////////////////////////////////////////////////////

    /* ------------------ Testing purpoces ------------------- */

    ////////////////////////////////////////////////////////////

    // EFFECTS: set connections list for testing purposes
    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    // EFFECTS: set connections numOfConnections for testing purposes
    public void setnumOfConnections(int num) {
        this.numOfConnections = num;
    }
}
