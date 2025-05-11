package persistence;

import model.Connection;
import model.Network;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads Network from JSON data stored in file
// CITATION: code pulled, used or inspired from JsonSerializationDemo
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    // CITATION: code pulled, used or inspired from JsonSerializationDemo
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Network from file and returns it;
    // throws IOException if an error occurs reading data from file
    // CITATION: code pulled, used or inspired from JsonSerializationDemo
    public Network read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseNetwork(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    // CITATION: code pulled, used or inspired from JsonSerializationDemo
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Network from JSON object and returns it
    // CITATION: code pulled, used or inspired from JsonSerializationDemo
    private Network parseNetwork(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Network n = new Network(name);
        addNetworkConnections(n, jsonObject);
        return n;
    }

    // MODIFIES: wr
    // EFFECTS: parses Connection from JSON object and adds them to Network
    // CITATION: code pulled, used or inspired from JsonSerialization
    private void addNetworkConnections(Network n, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("connections");
        for (Object json : jsonArray) {
            JSONObject nextConnection = (JSONObject) json;
            addNetworkConnection(n, nextConnection);
        }
    }

    // MODIFIES: n
    // EFFECTS: parses thingy from JSON object and adds it to Network
    // CITATION: code pulled, used or inspired from JsonSerialization
    private void addNetworkConnection(Network n, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String pronouns = jsonObject.getString("pronouns");
        String company = jsonObject.getString("company");
        String jobTitle = jsonObject.getString("jobTitle");
        String description = jsonObject.getString("description");

        Connection connection = new Connection(name, pronouns, company, jobTitle, description);
        n.addConnection(connection);
    }

}
