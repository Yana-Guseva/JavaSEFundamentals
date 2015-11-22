package javase.homework._02._02;

/**
 * Created by Yana on 18.10.2015.
 */
public class Pen {
    private float cost;
    private String brand;
    private int colour;

    Pen() {

    }

    Pen(float cost, String brand, int colour) {
        this.cost = cost;
        this.brand = brand;
        this.colour = colour;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}