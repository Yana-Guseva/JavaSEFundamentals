package javase.homework._10._01;

import java.sql.*;

/**
 * Created by Yana on 19.11.2015.
 */
public class ExecutePreparedStatement {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet set = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql;

            System.out.println("\nДо обновления: ");
            printAll();

            //Update
            sql = "SELECT * FROM students";
            set = statement.executeQuery(sql);
            while (set.next()) {
                if (set.getInt(3) == 4306) {
                    set.updateInt(3, 2307);
                    set.updateRow();
                }
            }
            statement.executeUpdate("UPDATE students SET name = 'Шишкина Анна' WHERE id = '2'");
            System.out.println("\nПосле обновления: ");
            printAll();

            //PreparedStatement
            System.out.println("\nПодготовленный запрос: ");
            sql = "SELECT name FROM students WHERE group_number = ?";
            PreparedStatement rs = connection.prepareStatement(sql);
            rs.setInt(1, 2307);
            set = rs.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1));
            }

            //Query
            System.out.println("\nВыбор конкретной записи: ");
            set = statement.executeQuery("SELECT * FROM students WHERE id = 3");
            if (set.next())
                System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3));

            //Insert
            statement.executeUpdate("INSERT INTO students(name, group_number) VALUES (\"Осипова Мария\", 1313)");
            System.out.println("\nВтавка новой записи");
            printAll();

//            statement.executeUpdate("DROP TABLE students");
//            System.out.println("\nТаблица удалена");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (set != null) {
                    set.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printAll() throws SQLException {
        String query = "SELECT * FROM students";
        set = statement.executeQuery(query);
        while (set.next()) {
            System.out.println(set.getInt(1) + " " + set.getString(2) + " " + set.getInt(3));
        }
    }
}
