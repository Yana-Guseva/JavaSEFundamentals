package javase.homework._10._02;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yana on 20.11.2015.
 */
public interface GenericDao<T> {

    public T create();
    public T persist(T object);
    public T read(int key) throws SQLException;
    public void update(T object);
    public void delete(T object);
    public List<T> getAll() throws SQLException;
    public void printAll(List<T> list);
}
