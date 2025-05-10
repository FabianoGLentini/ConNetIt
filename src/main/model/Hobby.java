package model;

import javax.swing.text.AttributeSet.ColorAttribute;

// A class representing Hobby, with hobby title
public class Hobby {
    private String title;
    private ColorAttribute color;
    // TODO Create Enum for colors in new field list hobbies class?

    // EFFECTS: create Hobbie instance
    public Hobby(String title) {
        this.title = title;
        this.color = null; // TODO add default color
    }

    // EFFECT: returns Hobbie title
    public String getTitle() {
        return title;
    }

    // MODIFFIES: this
    // EFFECT: sets Hobbie title
    public void setTitle(String title) {
        this.title = title;

    }

    // MODIFFIES: this
    // EFFECTS: sets color
    public void setColor() {
        // TODO
    }
}
