package javase.homework._10._02;

import javase.homework._10._02.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Yana on 20.11.2015.
 */
public class MySQLDaoFactory implements DAOFactory {
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/library_db";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private ConnectionPool pool;

    public MySQLDaoFactory() {
//            Class.forName(DRIVER);
        pool = new ConnectionPool();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return pool.getConnection();
//        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public MySQLDaoAuthor getAuthorDao(Connection connection) {
        return new MySQLDaoAuthor(connection);
    }

    @Override
    public MySQLDaoBook getBookDao(Connection connection) {
        return new MySQLDaoBook(connection);
    }
}
