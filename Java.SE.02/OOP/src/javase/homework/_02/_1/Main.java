package javase.homework._02._1;

/**
 * Created by Yana on 14.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        final int COLOUR_BLUE = 0;
        final int COLOUR_BLACK = 1;

        Pen pen = new Pen(COLOUR_BLUE, 12.4f, "brandName1");
        System.out.println("\nCreated pen: " + pen.toString());
        Pen anotherPen = new Pen(COLOUR_BLACK, 16.9f, "brandName2");
        System.out.println("\nCreated pen: " + anotherPen.toString());
        Pen samePen = new Pen(COLOUR_BLUE, 12.4f, "brandName1");
        System.out.println("\nCreated pen: " + anotherPen.toString());

        System.out.println();
        System.out.println("pen equals anotherPen: " + pen.equals(anotherPen));
        System.out.println("pen equals pen: " + pen.equals(pen));
        System.out.println("pen equals samePen: " + pen.equals(samePen));

        System.out.println();
        System.out.println("hashCode pen: " + pen.hashCode());
        System.out.println("hashCode anotherPen: " + anotherPen.hashCode());
        System.out.println("hashCode samePen: " + samePen.hashCode());
    }
}
