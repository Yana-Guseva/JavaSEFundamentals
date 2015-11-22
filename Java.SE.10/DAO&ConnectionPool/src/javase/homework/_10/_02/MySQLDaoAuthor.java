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
public class MySQLDaoAuthor extends AbstractJDBCDao<Author> {

    private class CreateAuthor extends Author {
        public void setId(int id) {
            super.setId(id);
        }
    }

    public MySQLDaoAuthor(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, name, year_of_birth, year_of_death FROM author ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE author SET name= ?, year_of_birth = ?, year_of_death = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM author WHERE id= ?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO author (name, year_of_birth, year_of_death) VALUES (?, ?, ?);";
    }

    @Override
    public Author create() {
        Author author = new Author();
        return persist(author);
    }

    @Override
    public void printAll(List<Author> list) {
        for (Author author : list) {
            System.out.println(author.getId() + " " + author.getName() + " "
                    + author.getYearOfBirth() + " " + author.getYearOfDeath());
        }
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement stm, Author object) {
        try {
            stm.setString(1, object.getName());
            stm.setInt(2, object.getYearOfBirth());
            stm.setInt(3, object.getYearOfDeath());
            stm.setInt(4, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForDelete(PreparedStatement stm, Author object) {
        try {
            stm.setInt(1, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForInsert(PreparedStatement stm, Author object) {
        try {
            stm.setString(1, object.getName());
            stm.setInt(2, object.getYearOfBirth());
            stm.setInt(3, object.getYearOfDeath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Author> parseResultSet(ResultSet set) {
        List<Author> list = new ArrayList<Author>();
        try {
            while (set.next()) {
                Author author = new Author();
                author.setId(set.getInt("id"));
                author.setName(set.getString("name"));
                author.setYearOfBirth(set.getInt("year_of_birth"));
                author.setYearOfDeath(set.getInt("year_of_death"));
                list.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
