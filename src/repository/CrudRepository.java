package repository;

import java.util.List;

public interface CrudRepository<T> {
    void create(T entity);
    List<T> getAll();
    void delete(int id);
}
