package javase.homeworks._02._03;

/**
 * Created by Yana on 18.10.2015.
 */
public class Pencil extends Stationery {

    Pencil(float cost, String brand) {
        super(cost, brand);
    }

    @Override
    public String toString() {
        return getClass() + " cost: " + super.getCost() + ", brand: " + super.getBrand();
    }
}
