package javase.homework._02._02;

/**
 * Created by Yana on 18.10.2015.
 */
public class NooteBook {
    private float cost;
    private String brand;
    private int mode;

    NooteBook() {

    }

    NooteBook(float cost, String brand, int mode) {
        this.cost = cost;
        this.brand = brand;
        this.mode = mode;
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

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
