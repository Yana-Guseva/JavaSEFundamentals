package javase.homework._10._02;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public abstract class AbstractJDBCDao<T> implements GenericDao<T> {
    private Connection connection;

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public abstract String getSelectQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    public abstract String getCreateQuery();
    public abstract void prepareStatementForUpdate(PreparedStatement stm, T object);
    public abstract void prepareStatementForDelete(PreparedStatement stm, T object);
    public abstract void prepareStatementForInsert(PreparedStatement stm, T object);
    protected abstract List<T> parseResultSet(ResultSet set);

    @Override
    public T persist(T object) {
        T instance = null;
        String sql = getCreateQuery();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            prepareStatementForInsert(stm, object);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = getSelectQuery() + "WHERE id = last_insert_id();";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet set = stm.executeQuery();
            List<T> list = parseResultSet(set);
            instance = list.iterator().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    public T read(int key) throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, key);
        ResultSet set = stm.executeQuery();
        list = parseResultSet(set);
        if (list == null || list.size() == 0)
            return null;
        return list.iterator().next();
    }

    @Override
    public void update(T object) {
        String sql = getUpdateQuery();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            prepareStatementForUpdate(stm, object);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T object) {
        String sql = getDeleteQuery();
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            prepareStatementForDelete(stm, object);
            stm.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Нельзя удалить автора. Сначала удалите все его книги.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() throws SQLException {
        List<T> list;
        String sql = getSelectQuery();
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery();
        list = parseResultSet(set);
        return list;
    }
}
