package javase.homework._02._04;

import java.util.Comparator;

/**
 * Created by Yana on 18.10.2015.
 */
public class SortedByCost implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        if (o1.getCost() > o2.getCost()) {
            return 1;
        }
        if (o1.getCost() < o2.getCost()) {
            return -1;
        } else {
            return 0;
        }
    }
}
