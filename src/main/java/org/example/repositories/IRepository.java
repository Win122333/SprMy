package org.example.repositories;

import java.util.List;

public interface IRepository<T> {
    void save(T entity);
    T findById(int id);
    List<T> findAll();
    boolean delete(int id);
    void update(T entity, int id);
}
