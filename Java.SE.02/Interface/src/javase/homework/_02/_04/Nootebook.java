package javase.homework._02._04;

/**
 * Created by Yana on 18.10.2015.
 */
public class Nootebook extends Stationery {
    private int countOfPaper;

    Nootebook(float cost, String brand, int countOfPaper) {
        super(cost, brand);
        this.countOfPaper = countOfPaper;
    }

    public int getCountOfPaper() {
        return countOfPaper;
    }
}
