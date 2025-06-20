package model;


// A class representing Hobby, with hobby tittle
public class Hobby {
    private String tittle;


    // EFFECTS: create Hobbie instance
    public Hobby(String tittle) {
        this.tittle = tittle;
    }

    // EFFECT: returns Hobbie tittle
    public String getTittle() {
        return tittle;
    }

    // MODIFFIES: this
    // EFFECT: sets Hobbie tittle
    public void setTittle(String tittle) {
        this.tittle = tittle;

    }

}
