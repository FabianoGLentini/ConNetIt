package model;

import java.util.HashMap;

// A class that represents the collection of Hobbies,
// insure no duplicates of hobbie instances,
// accure and handle hobbie creation and assignment when called oppon
public class Hobbies {
    private HashMap<String, Hobby> hobbyTracker;

    // EFFECTS: construcor creates a single Hobbies to track Hobbie creation.
    // This is to prevent duplication of similarly named Hobbie instances
    public Hobbies() {
        hobbyTracker = new HashMap<>();
    }

    // EFFECTS: adds new hobby with associated name in lowercase
    // into hobbieTrack. Prevents duplicates of hobbie
    public void addHobbieToTrack(String title, Hobby hobby) {
        String trackId = title.toLowerCase();

        hobbyTracker.put(trackId, hobby);

    }

    // REQUIRES: existingHobby()
    // EFFECTS: returns hobby from map based on title.
    public Hobby getHobbyFromTrack(String title) {
        String trackId = title.toLowerCase();

        return hobbyTracker.get(trackId);
    }

    // REQUIRES: !existingHobby()
    // MODDIFIES: this
    // EFFECTS: creates new hobbie from title & add to hobbyTracker
    public Hobby createNewHobby(String title) {
        Hobby hobby = new Hobby(title);

        this.addHobbieToTrack(title, hobby);
        return hobby;
    }

    // EFFECTS: checks if Hobbie with associate String name already exist return
    // true if yes else false
    public boolean existingHobby(String title) {
        String trackId = title.toLowerCase();

        return hobbyTracker.containsKey(trackId);
    }

    // EFFECTS: return Hasmap of hobbieTrack
    public HashMap<String, Hobby> getTrackedHobbies() {

        return hobbyTracker;
    }

    // MODDIFIES: this
    // EFFECTS: sets hobbieTrack for testing purposes
    public void setTrackedHobbies(HashMap<String, Hobby> hobbyTracker) {
        this.hobbyTracker = hobbyTracker;
    }

}
