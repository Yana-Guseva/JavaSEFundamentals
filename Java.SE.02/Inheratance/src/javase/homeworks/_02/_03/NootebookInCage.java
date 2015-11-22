package javase.homeworks._02._03;

/**
 * Created by Yana on 18.10.2015.
 */
public class NootebookInCage extends Nootebook{
    private int sizeOfCage;

    NootebookInCage(float cost, String brand, int size, int sizeOfCage) {
        super(cost, brand, size);
        this.sizeOfCage = sizeOfCage;
    }

    @Override
    public String toString() {
        return getClass() + " cost: " + super.getCost() + ", brand: " +
                super.getBrand() + ", countOfPaper " + super.getCountOfPaper() + ", sizeOfCage " + sizeOfCage;
    }
}
