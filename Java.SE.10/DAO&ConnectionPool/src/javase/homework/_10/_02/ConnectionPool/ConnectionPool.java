package javase.homework._10._02.ConnectionPool;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Yana on 20.11.2015.
 */
public class ConnectionPool {
    private BlockingQueue<Connection> availableConns;
    private BlockingQueue<Connection> usedConns;

    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/library_db";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private int poolSize = 5;

    public ConnectionPool() {
        try {
            Class.forName(DRIVER);
            availableConns = new ArrayBlockingQueue<Connection>(poolSize);
            usedConns = new ArrayBlockingQueue<Connection>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                availableConns.add(getConnection());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection takeConnection() {
        Connection conn = null;
        if (availableConns.size() == 0) {
            conn = getConnection();
        } else {
            try {
                conn = availableConns.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        usedConns.add(conn);
        return conn;
    }

    public synchronized void putBack(Connection conn) {
        if ((conn != null) && (availableConns.size() < poolSize)) {
            try {
                usedConns.take();
                availableConns.add(conn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void released() {
        Iterator allConns = availableConns.iterator();
        while (allConns.hasNext()) {
            Connection conn = (Connection) allConns.next();
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        availableConns.clear();
    }
}
