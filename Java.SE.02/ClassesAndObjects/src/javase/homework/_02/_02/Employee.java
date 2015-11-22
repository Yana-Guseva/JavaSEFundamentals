package javase.homework._02._02;

import java.util.ArrayList;

/**
 * Created by Yana on 18.10.2015.
 */
public class Employee {

    private String name;
    private ArrayList<Pen> pens;
    private ArrayList<Pencil> pencils;
    private ArrayList<NooteBook> nooteBooks;

    Employee(String name) {
        this.name = name;
        pens = new ArrayList<>();
        pencils = new ArrayList<>();
        nooteBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pen> getPens() {
        return pens;
    }

    public ArrayList<Pencil> getPencils() {
        return pencils;
    }

    public ArrayList<NooteBook> getNooteBooks() {
        return nooteBooks;
    }

    public void addPen(Pen newPen) {
        pens.add(newPen);
    }

    public void addPencil(Pencil newPencil) {
        pencils.add(newPencil);
    }

    public void addNooteBook(NooteBook newNootebook) {
        nooteBooks.add(newNootebook);
    }

    public void removePen(Pen pen) {
        pens.remove(pen);
    }

    public void removePencil(Pencil pencil) {
        pencils.remove(pencil);
    }

    public void removeNooteBook(NooteBook nootebook) {
        nooteBooks.remove(nootebook);
    }

    public float getFullPrice(ArrayList<Pen> pens, ArrayList<Pencil> pencils, ArrayList<NooteBook> nooteBooks) {
        float fullPrice = 0;
        for (Pen pen : pens) {
            fullPrice += pen.getCost();
        }

        for (Pencil pencil : pencils) {
            fullPrice += pencil.getCost();
        }

        for (NooteBook nooteBook : nooteBooks) {
            fullPrice += nooteBook.getCost();
        }

        return fullPrice;
    }
}
