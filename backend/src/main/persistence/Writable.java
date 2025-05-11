package persistence;

import org.json.JSONObject;

// CITATION: code pulled, used or inspired from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
