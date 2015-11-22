package javase.homework._02._04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 18.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        final int COLOUR_BLACK = 0;
        final int COLOUR_BLUE = 1;

        List<Stationery> begginerSet = new ArrayList();
        begginerSet.add(new ColoredPen(14.2f, "brand1", COLOUR_BLACK));
        begginerSet.add(new ColoredPen(13.2f, "brand4", COLOUR_BLUE));
        begginerSet.add(new Pencil(5.3f, "brand8"));
        begginerSet.add(new Pencil(5.3f, "brand3"));
        begginerSet.add(new NootebookInCage(27.4f, "brand3", 25, 1));
        begginerSet.add(new NootebookInLine(23.4f, "brand1", 25, 2));

        System.out.println("Begginer set: ");
        printBegginerSet(begginerSet);

        System.out.println("Sorted by cost: ");
        begginerSet.sort(new SortedByCost());
        printBegginerSet(begginerSet);

        System.out.println("Sorted by brand: ");
        begginerSet.sort(new SortedByBrand());
        printBegginerSet(begginerSet);

        System.out.println("Sorted by cost and brand: ");
        begginerSet.sort(new SortedByCostAndBrand());
        printBegginerSet(begginerSet);
    }

    public static void printBegginerSet(List<Stationery> begginerSet) {
        for (Stationery stationery : begginerSet) {
            System.out.println(stationery.toString());
        }
    }
}