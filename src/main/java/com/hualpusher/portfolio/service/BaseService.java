package com.hualpusher.portfolio.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    T save(T t);
    Optional<T> findById(ID id);
    List<T> findAll();

    T update(ID id, T t) throws Exception;

    void deleteById(ID id);
}
