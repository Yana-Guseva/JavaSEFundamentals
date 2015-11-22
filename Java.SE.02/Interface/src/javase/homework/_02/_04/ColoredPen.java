package javase.homework._02._04;

/**
 * Created by Yana on 18.10.2015.
 */
public class ColoredPen extends Pen {
    private int colour;

    ColoredPen(float cost, String brand, int colour) {
        super(cost, brand);
        this.colour = colour;
    }

    @Override
    public String toString() {
        return getClass() + " coast: " + super.getCost() + ", brand: " +
                super.getBrand() + ", colour: " + colour;
    }
}