package javase.homework._10._02;

/**
 * Created by Yana on 20.11.2015.
 */
public class Book {
    private int id;
    private String name;
    private int year;
    private int authorId;

    public Book() {

    }

    public Book(int id, String name, int year, int authorId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.authorId = authorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
