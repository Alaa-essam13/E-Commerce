package com.example.ecommerce.ecommerce.lib.search;

import java.util.List;
import java.util.Optional;

public interface searchCriteriaQuery<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    List<T> findByParams(FilterParams params, QueryOptions options);

    T save(T entity);

    void deleteById(ID id);

    List<T> searchAllColumns(String keyword, QueryOptions options);

    long countBySearchAllColumns(String keyword);
}
