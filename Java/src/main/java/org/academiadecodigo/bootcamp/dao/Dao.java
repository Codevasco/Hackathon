package org.academiadecodigo.bootcamp.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T getById(Integer id);

    T saveOrUpdate(T modelObject);

    void delete(Integer id);

}
