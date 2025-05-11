package model;

import java.util.Set;

import org.json.JSONObject;

import persistence.Writable;

import java.util.HashSet;

// A class representing connection card with name, pronouns, jobTitle & description
public class Connection implements Writable {
    private String name;
    private String pronouns;
    private String company;
    private String jobTitle;
    private String description;
    private Set<Hobby> hobbiesSet;

    // EFFECTS: create connection profile, with empty hobbiesTags list
    public Connection(String name, String pronouns, String company, String jobTitle, String description) {
        this.name = name;
        this.pronouns = pronouns;
        this.company = company;
        this.jobTitle = jobTitle;
        this.description = description;
        this.hobbiesSet = new HashSet<>();

    }

    /* -----Getter Methods----- */

    // EFFECTS: get connection field based on inputed enum
    public String getField(ConnectionField field) {
        switch (field) {
            case NAME:
                return this.name;
            case PRONOUNS:
                return this.pronouns;
            case COMPANY:
                return this.company;
            case JOBTITLE:
                return this.jobTitle;
            case DESCRIPTION:
                return this.description;
            default:
                return null;
        }
    }

    /* -----Setter Methods----- */

    // MODIFFIES: this
    // EFFECTS: set connection field based on inputed enum
    public String setField(ConnectionField field, String value) {
        switch (field) {
            case NAME:
                EventLog.logEvent("Updated Name:" + this.name + " to " + value);
                return this.name = value;
            case PRONOUNS:
                EventLog.logEvent("Updated Pronouns:" + this.pronouns + " to " + value);
                return this.pronouns = value;
            case COMPANY:
                EventLog.logEvent("Updated Company:" + this.company + " to " + value);
                return this.company = value;
            case JOBTITLE:
                EventLog.logEvent("Updated Job Title:" + this.jobTitle + " to " + value);
                return this.jobTitle = value;
            case DESCRIPTION:
                EventLog.logEvent("Updated Job Description: \n" + this.description + "\n To: \n" + value);
                return this.description = value;
            default:
                return null;
        }
    }

    /*----Json relate save and load methods----*/

    @Override
    // EFFECTS: create Json version of Connection class
    // For saving and loading purposes
    // CITATION: code pulled, used or inspired from JsonSerialization
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("pronouns", pronouns);
        json.put("company", company);
        json.put("jobTitle", jobTitle);
        json.put("description", description);
        json.put("hobbiesSet", hobbiesSet);

        return json;
    }

}
