package com.example.ecommerce.ecommerce.lib.search;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * AbstractCriteriaQueryBuilder:
 *
 */
public abstract class AbstractCriteriaQueryBuilder<T, F> {
    @PersistenceContext
    protected EntityManager entityManager;
    protected final Class<T> entityClass;

    protected AbstractCriteriaQueryBuilder( Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *  use it to build your query
     */
    protected abstract HqlBuilder<T> buildQuery(F filter);

    /**
     * get list of result after executing query
     */
    public List<T> getList(F filter, int offset, int limit) {
        HqlBuilder<T> builder = buildQuery(filter);

        builder.paginate(offset, limit);

        String hql = builder.getQueryString();
        Query query = entityManager.createQuery(hql);

        for (Map.Entry<String, Object> entry : builder.getParams().entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        if (limit > 0) {
            query.setFirstResult(offset);
            query.setMaxResults(limit);
        }

        return query.getResultList();
    }

    /**
     * get count of items without pagination
     */
    public long getCount(F filter) {
        HqlBuilder<T> builder = buildQuery(filter);
        builder.selectCount();

        String hql = builder.getQueryString();
        Query query = entityManager.createQuery(hql);

        for (Map.Entry<String, Object> entry : builder.getParams().entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return (long) query.getSingleResult();
    }
}
