package ru.x5.service.dao;

public interface DAO<T> {
    T get(int id);

    void save(T t);

    void update(T t);

    void delete(T t);
}
