package com.example.ecommerce.ecommerce.lib.search;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class FilterParams {

    private final Map<String, Object> params = new HashMap<>();

    public void add(String key, Object value) {
        params.put(key, value);
    }

    public boolean isEmpty() {
        return params.isEmpty();
    }
}
