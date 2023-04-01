package com.example.rest.dto;

public class JsonWrapper {
    private Object value;

    public JsonWrapper(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
