package daos;

import java.util.List;

public interface DaoInterface<T> {
    public T findById(int id);
    public List findAll();
    public T update(T dto);
    public T create(T dto);
    public void delete(int id);
}
