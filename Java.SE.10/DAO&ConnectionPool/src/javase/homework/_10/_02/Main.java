package javase.homework._10._02;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        MySQLDaoFactory factory = new MySQLDaoFactory();
        try {
            MySQLDaoAuthor daoAuthor = factory.getAuthorDao(factory.getConnection());
            MySQLDaoBook daoBook = factory.getBookDao(factory.getConnection());

            System.out.println("\nВсе авторы:");
            daoAuthor.printAll(daoAuthor.getAll());
            System.out.println("\nВсе книги:");
            daoBook.printAll(daoBook.getAll());

            Author author = daoAuthor.create();
            author.setName("Керуак");
            author.setYearOfBirth(1938);
            author.setYearOfDeath(1987);
            daoAuthor.update(author);
            daoAuthor.printAll(daoAuthor.getAll());

            System.out.println("\nУдаление автора:");
            try {
                daoAuthor.delete(daoAuthor.getAll().get(3));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Автора с таким id нет.");
            }
            daoAuthor.printAll(daoAuthor.getAll());


            System.out.println("\nАвтор по id");
            author = daoAuthor.read(1);
            System.out.println(author.getId() + " " + author.getName() + " " +
                    author.getYearOfBirth() + " " + author.getYearOfDeath());

            System.out.println("\nКниги автора " + author.getName());
            List<Book> listBook = daoBook.getBooksForAuthor(author.getId());
            daoBook.printAll(listBook);

            Book book = daoBook.read(3);
            System.out.println("\nУдаление книги: ");
            try {
                daoBook.delete(book);
            } catch (NullPointerException e) {
                System.out.println("Книги с таким id нет");
            }
            daoBook.printAll(daoBook.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Success!");
    }
}
