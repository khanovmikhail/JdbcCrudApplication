package com.khanovmikhail.repository;

import java.util.List;

public interface CrudDao<E> {

    List<E> findAll();
    E findById(int id);
    E save(E entity);
    void update(E entity);
    void delete(E entity);
}
