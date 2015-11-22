package javase.homework._02._1;

/**
 * Created by Yana on 14.10.2015.
 */
public class Pen {
    private int colour;
    private float cost;
    private String brand;

    Pen() {
    }

    Pen(int colour, float cost, String brand) {
        this.colour = colour;
        this.cost = cost;
        this.brand = brand;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public int getColour() {
        return colour;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void write() {
        System.out.println("write");
    }

    @Override
    public int hashCode() {
        return (int) (31 * cost + 37 * colour + (null == brand ? 0 : brand.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pen pen = (Pen) obj;
        if (colour != pen.colour) {
            return false;
        }
        if (cost != pen.cost) {
            return false;
        }
        if (null == brand) {
            return (null == pen.brand);
        } else {
            if (!brand.equals(pen.brand)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "class: " + getClass() + "\ncolour: " + colour +
                "\ncost: " + cost + "\nbrand: " + brand;
    }
}
