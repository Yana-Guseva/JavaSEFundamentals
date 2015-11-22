package javase.homework._10._02;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Yana on 20.11.2015.
 */
public interface DAOFactory {
    public Connection getConnection() throws SQLException;
    public MySQLDaoAuthor getAuthorDao(Connection connection);
    public MySQLDaoBook getBookDao(Connection connection);
}
