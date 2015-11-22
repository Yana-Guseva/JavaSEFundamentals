package javase.homeworks._02._03;

import java.util.ArrayList;

/**
 * Created by Yana on 18.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        final int COLOUR_BLACK = 0;
        final int COLOUR_BLUE = 1;

        ArrayList<Stationery> begginerSet = new ArrayList();
        begginerSet.add(new ColoredPen(13.2f, "brand1", COLOUR_BLUE));
        begginerSet.add(new ColoredPen(14.2f, "brand1", COLOUR_BLACK));
        begginerSet.add(new Pencil(5.3f, "brand2"));
        begginerSet.add(new NootebookInCage(23.4f, "brand3", 25, 1));
        begginerSet.add(new NootebookInLine(23.4f, "brand3", 25, 2));

        System.out.println("Begginer set: ");
        for (Stationery stationery : begginerSet) {
            System.out.println(stationery.toString());
        }
    }
}