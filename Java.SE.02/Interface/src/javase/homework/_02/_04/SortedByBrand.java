package javase.homework._02._04;

import java.util.Comparator;

/**
 * Created by Yana on 18.10.2015.
 */
public class SortedByBrand implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        String brand1 = o1.getBrand();
        String brand2 = o2.getBrand();
        return brand1.compareTo(brand2);
    }
}
