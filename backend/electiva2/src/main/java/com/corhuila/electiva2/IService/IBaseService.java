package com.corhuila.electiva2.IService;

import com.corhuila.electiva2.Entity.ABaseEntity;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T extends ABaseEntity> {

    List<T> all();
    List<T> findByStateTrue();
    T findById(Long id) throws Exception;
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;
}