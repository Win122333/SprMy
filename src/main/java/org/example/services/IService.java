    package org.example.services;
    import java.util.List;

    public interface IService<T> {
        List<T> getAll();
        T getItemById(int id);
        boolean delete(int id);
        void update(T entity, int id);
        void create(T entity);
    }
