package javase.homework._02._04;

import java.util.Comparator;

/**
 * Created by Yana on 18.10.2015.
 */
public class Stationery{
    private float cost;
    private String brand;

    Stationery(float cost, String brand) {
        this.cost = cost;
        this.brand = brand;
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
}
