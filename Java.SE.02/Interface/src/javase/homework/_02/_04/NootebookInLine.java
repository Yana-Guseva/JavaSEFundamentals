package javase.homework._02._04;

/**
 * Created by Yana on 18.10.2015.
 */
public class NootebookInLine extends Nootebook {
    private int sizeOfLine;

    NootebookInLine(float cost, String brand, int countOfPaper, int sizeOfLine) {
        super(cost, brand, countOfPaper);
        this.sizeOfLine = sizeOfLine;
    }

    @Override
    public String toString() {
        return getClass() + " cost: " + super.getCost() + ", brand: " +
                super.getBrand() + ", countOfPaper " + super.getCountOfPaper() + ", sizeOfCage " + sizeOfLine;
    }
}
