package javase.homework._02._02;

/**
 * Created by Yana on 18.10.2015.
 */
public class Main {

    public static void main(String[] args) {
        final int COLOUR_BLUE = 0;
        final int COLOUR_BLACK = 1;
        final int NOOTEBOOK_IN_CAGE = 3;
        final int NOOTEBOOK_IN_LINE = 4;

        Employee employee = new Employee("Jhon");
        employee.addPen(new Pen(12.3f, "brand1", COLOUR_BLACK));
        employee.addPen(new Pen(5.6f, "brand1", COLOUR_BLUE));
        employee.addPencil(new Pencil(4.1f, "brand2"));
        employee.addNooteBook(new NooteBook(3.5f, "brand2", NOOTEBOOK_IN_CAGE));

        System.out.println("Total price for " + employee.getName() + " = " +
                employee.getFullPrice(employee.getPens(), employee.getPencils(), employee.getNooteBooks()));
    }
}