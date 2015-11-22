package javase.homework._02._04;

import java.util.Comparator;

/**
 * Created by Yana on 19.10.2015.
 */
public class SortedByCostAndBrand implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        float temp = o1.getCost() - o2.getCost();
        if (temp > 0) {
            return 1;
        }
        if (temp < 0) {
            return  -1;
        }

        String brand1 = o1.getBrand();
        String brand2 = o2.getBrand();
        return brand1.compareTo(brand2);
    }
}
