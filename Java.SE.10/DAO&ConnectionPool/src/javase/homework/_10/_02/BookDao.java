package javase.homework._10._02;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public interface BookDao {
    public Book create();
    public void read(int key);
    public void uodate(Book author);
    public void delete(Book author);
    public List<Book> getAll() throws SQLException;
}
