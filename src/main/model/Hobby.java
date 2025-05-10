package model;


// A class representing Hobby, with hobby tittle
public class Hobby {
    private String tittle;
    // TODO add color field


    // EFFECTS: create Hobbie instance
    public Hobby(String tittle) {
        this.tittle = tittle;
    }

    // EFFECT: returns Hobbie tittle
    public String getTitle() {
        return tittle;
    }

    // MODIFFIES: this
    // EFFECT: sets Hobbie tittle
    public void setTitle(String tittle) {
        this.tittle = tittle;

    }

}
