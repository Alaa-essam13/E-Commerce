package com.example.ecommerce.ecommerce.lib.search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConditionBuilder {
    private final StringBuilder sb = new StringBuilder();
    private final Map<String, Object> params = new LinkedHashMap<>();
    private final Deque<String> groupStack = new ArrayDeque<>();
    private boolean isEmpty = true;

    public ConditionBuilder and(String condition, String param, Object value) {
        append("AND", condition, param, value);
        return this;
    }

    public ConditionBuilder andEq(String field, String param, Object value) {
        return and(field + " = :" + param, param, value);
    }

    public ConditionBuilder andLike(String field, String param, String value) {
        return and(field + " LIKE :" + param, param, "%" + value + "%");
    }

    public ConditionBuilder andBetween(String field, String p1, String p2, Object v1, Object v2) {
        if (!sb.isEmpty()) sb.append(" AND ");
        sb.append("(").append(field).append(" BETWEEN :").append(p1)
                .append(" AND :").append(p2).append(")");
        params.put(p1, v1);
        params.put(p2, v2);
        isEmpty = false;
        return this;
    }

    public ConditionBuilder or(String condition, String param, Object value) {
        append("OR", condition, param, value);
        return this;
    }

    public ConditionBuilder orLike(String field, String param, String value) {
        return or(field + " LIKE :" + param, param, "%" + value + "%");
    }

    public void openGroup() {
        if (!sb.isEmpty()) sb.append(" AND ");
        sb.append("(");
        groupStack.push("(");
    }

    public void closeGroup() {
        if (groupStack.isEmpty())
            throw new IllegalStateException("Cannot close group that is not open");
        sb.append(")");
        groupStack.pop();
    }

    private void append(String keyword, String condition, String param, Object value) {
        if (!isEmpty) sb.append(" ").append(keyword).append(" ");
        sb.append(condition);
        if (param != null && value != null) params.put(param, value);
        isEmpty = false;
    }

    public String build() {
        if (!groupStack.isEmpty())
            throw new IllegalStateException("Unbalanced parentheses: some groups not closed");
        return sb.toString();
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
