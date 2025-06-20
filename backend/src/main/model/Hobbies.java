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
    public void addHobbieToTrack(String tittle, Hobby hobby) {
        String trackId = tittle.toLowerCase();

        hobbyTracker.put(trackId, hobby);

    }

    // REQUIRES: existingHobby()
    // EFFECTS: returns hobby from map based on tittle.
    public Hobby getHobbyFromTrack(String tittle) {
        String trackId = tittle.toLowerCase();

        return hobbyTracker.get(trackId);
    }

    // REQUIRES: !existingHobby()
    // MODDIFIES: this
    // EFFECTS: creates new hobbie from tittle & add to hobbyTracker
    public Hobby createNewHobby(String tittle) {
        Hobby hobby = new Hobby(tittle);

        this.addHobbieToTrack(tittle, hobby);

        return hobby;
    }

    // EFFECTS: checks if Hobbie with associate String name already exist return
    // true if yes else false
    public boolean existingHobby(String tittle) {
        String trackId = tittle.toLowerCase();

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
