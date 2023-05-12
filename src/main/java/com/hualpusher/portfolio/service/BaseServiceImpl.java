package com.hualpusher.portfolio.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    private JpaRepository<T, ID> repository;

    public BaseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T update(ID id, T t) throws Exception {
        if (!repository.existsById(id)) {
            throw new Exception("No resource found for ID: " + id);
        }

        return repository.save(t);
    }


    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}

