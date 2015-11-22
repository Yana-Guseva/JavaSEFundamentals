package javase.homework._10._02;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public interface AuthorDao {
    public Author create();
    public Author read(int key) throws SQLException;
    public void uodate(Author author);
    public void delete(Author author);
    public List<Author> getAll() throws SQLException;
}
