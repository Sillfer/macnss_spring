package com.simplon.cnss.DAO;

import java.util.List;

public interface DAO<T> {

    T get(long id);

    void save(T t);

    List<T> getAll();

    void update(T t, String[] params);

    void delete(T t);
}
