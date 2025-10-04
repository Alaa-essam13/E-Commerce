package com.example.ecommerce.ecommerce.lib.search;

import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

//@Repository
@AllArgsConstructor
public abstract class searchCriteriaQueryImpl<T, ID> implements searchCriteriaQuery<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> entityClass;

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        String qlString = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(qlString, entityClass).getResultList();
    }

    @Override
    public List<T> findByParams(FilterParams params, QueryOptions options) {
        StringBuilder queryString = new StringBuilder("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE 1=1");

        params.getParams().forEach((key, value) -> {
            if (value == null) return;

            if (value instanceof String) {
                queryString.append(" AND LOWER(e.")
                        .append(key)
                        .append(") LIKE LOWER(:")
                        .append(key)
                        .append(")");
            } else {
                queryString.append(" AND e.")
                        .append(key)
                        .append(" = :")
                        .append(key);
            }
        });

        if (options != null && options.getSortBy() != null) {
            queryString.append(" ORDER BY e.")
                    .append(options.getSortBy())
                    .append(options.isAsc() ? " ASC" : " DESC");
        }

        TypedQuery<T> query = entityManager.createQuery(queryString.toString(), entityClass);

        params.getParams().forEach((key, value) -> {
            if (value instanceof String) {
                query.setParameter(key, "%" + value + "%");
            } else {
                query.setParameter(key, value);
            }
        });

        applyPagination(query, options);

        return query.getResultList();
    }

    @Override
    public T save(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(entity -> {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        });
    }

    @Override
    public List<T> searchAllColumns(String keyword, QueryOptions options) {
        StringBuilder queryString = new StringBuilder("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE 1=0");

        for (Field field : entityClass.getDeclaredFields()) {
            if (field.getType().equals(String.class) && field.isAnnotationPresent(Column.class)) {
                queryString.append(" OR LOWER(e.")
                        .append(field.getName())
                        .append(") LIKE LOWER(:keyword)");
            }
        }

        if (options != null && options.getSortBy() != null) {
            queryString.append(" ORDER BY e.")
                    .append(options.getSortBy())
                    .append(options.isAsc() ? " ASC" : " DESC");
        }

        TypedQuery<T> query = entityManager.createQuery(queryString.toString(), entityClass);
        query.setParameter("keyword", "%" + keyword + "%");

        applyPagination(query, options);

        return query.getResultList();
    }

    @Override
    public long countBySearchAllColumns(String keyword) {
        StringBuilder queryString = new StringBuilder("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e WHERE 1=0");

        for (Field field : entityClass.getDeclaredFields()) {
            if (field.getType().equals(String.class) && field.isAnnotationPresent(Column.class)) {
                queryString.append(" OR LOWER(e.")
                        .append(field.getName())
                        .append(") LIKE LOWER(:keyword)");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(queryString.toString(), Long.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getSingleResult();
    }

    private void applyPagination(TypedQuery<?> query, QueryOptions options) {
        if (options != null && options.getSize() > 0) {
            int page = Math.max(options.getPage(), 0);
            int size = Math.max(options.getSize(), 1);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
        }
    }
}
