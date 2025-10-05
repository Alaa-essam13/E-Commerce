package com.example.ecommerce.ecommerce.lib.search;

import java.util.*;
import java.util.function.Consumer;

public class HqlBuilder<T> {
    private final Class<T> entityClass;
    private final String alias;
    private final ConditionBuilder conditionBuilder = new ConditionBuilder();

    private final List<String> selectParts = new ArrayList<>();
    private final List<String> orderParts = new ArrayList<>();

    private int offset = 0;
    private int limit = 0;

    private boolean selectCount = false;
    private String groupBy = null;

    public HqlBuilder(Class<T> entityClass, String alias) {
        this.entityClass = entityClass;
        this.alias = alias;
    }

    // === SELECT ===
    public HqlBuilder<T> select(String... fields) {
        selectParts.addAll(Arrays.asList(fields));
        return this;
    }

    public HqlBuilder<T> selectCount() {
        selectCount = true;
        return this;
    }

    public HqlBuilder<T> groupBy(String field) {
        this.groupBy = field;
        return this;
    }

    // === WHERE ===
    public HqlBuilder<T> where(Consumer<ConditionBuilder> consumer) {
        consumer.accept(conditionBuilder);
        return this;
    }

    // === SEARCH ===
    public HqlBuilder<T> search(String searchTerm, String... fields) {
        if (searchTerm != null && !searchTerm.isEmpty()) {
            conditionBuilder.openGroup();
            for (int i = 0; i < fields.length; i++) {
                String param = "search" + i;
                if (i > 0) conditionBuilder.or(fields[i] + " LIKE :" + param, param, "%" + searchTerm + "%");
                else conditionBuilder.and(fields[i] + " LIKE :" + param, param, "%" + searchTerm + "%");
            }
            conditionBuilder.closeGroup();
        }
        return this;
    }

    // === ORDER BY ===
    public HqlBuilder<T> orderBy(String orderBy) {
        if (orderBy != null && !orderBy.isEmpty()) orderParts.add(orderBy);
        return this;
    }

    // === PAGINATION ===
    public HqlBuilder<T> paginate(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
    }


    public String getQueryString() {
        return buildQueryString();
    }

    public Map<String, Object> getParams() {
        return conditionBuilder.getParams();
    }


    private String buildQueryString() {
        StringBuilder hql = new StringBuilder();

        if (selectCount)
            hql.append("SELECT COUNT(").append(alias).append(") ");
        else if (!selectParts.isEmpty())
            hql.append("SELECT ").append(String.join(", ", selectParts)).append(" ");
        else
            hql.append("SELECT ").append(alias).append(" ");

        hql.append("FROM ").append(entityClass.getSimpleName()).append(" ").append(alias);

        String whereClause = conditionBuilder.build();
        if (!whereClause.isEmpty()) hql.append(" WHERE ").append(whereClause);

        if (groupBy != null) hql.append(" GROUP BY ").append(groupBy);

        if (!orderParts.isEmpty())
            hql.append(" ORDER BY ").append(String.join(", ", orderParts));

        return hql.toString();
    }
}
