package com.fly.repository.dao;

import java.util.List;

public interface GenericDAO<T, K> {
    List<T> findAll();

    T findById(K id);

    void delete(K id);

    T save(T entity);

    T update(T entity);


   }