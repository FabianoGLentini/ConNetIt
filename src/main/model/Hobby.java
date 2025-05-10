package model;


// A class representing Hobby, with hobby title
public class Hobby {
    private String title;
    // TODO add color field


    // EFFECTS: create Hobbie instance
    public Hobby(String title) {
        this.title = title;
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

}
