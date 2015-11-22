package javase.homework._10._02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public class MySQLDaoBook extends AbstractJDBCDao<Book> {

    public MySQLDaoBook(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, name, year, author_id FROM book";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE book SET name= ?, year = ?, author_id = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM book WHERE id= ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO book (name, year, author_id) VALUES (?, ?, ?);";
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement stm, Book object) {
        try {
            stm.setString(1, object.getName());
            stm.setInt(2, object.getYear());
            stm.setInt(3, object.getAuthorId());
            stm.setInt(4, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForDelete(PreparedStatement stm, Book object) {
        try {
            stm.setInt(1, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForInsert(PreparedStatement stm, Book object) {
        try {
            stm.setString(1, object.getName());
            stm.setInt(2, object.getYear());
            stm.setInt(3, object.getAuthorId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List parseResultSet(ResultSet set) {
        List<Book> list = new ArrayList<Book>();
        try {
            while (set.next()) {
                Book book = new Book();
                book.setId(set.getInt("id"));
                book.setName(set.getString("name"));
                book.setYear(set.getInt("year"));
                book.setAuthorId(set.getInt("author_id"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Book create() {
        Book book = new Book();
        return persist(book);
    }

    @Override
    public void printAll(List<Book> list) {
        for (Book book : list) {
            System.out.println(book.getId() + " " + book.getName() + " "
                    + book.getYear() + " " + book.getAuthorId());
        }
    }

    public String getQueryBooksForAuthor() {
        return "SELECT * FROM book WHERE author_id = ?";
    }

    public List<Book> getBooksForAuthor(int authorKey) {
        List<Book> list = new ArrayList<Book>();
        String sql = getQueryBooksForAuthor();
        try (PreparedStatement stm = getConnection().prepareStatement(sql)) {
            stm.setInt(1, authorKey);
            ResultSet set = stm.executeQuery();
            list = parseResultSet(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
