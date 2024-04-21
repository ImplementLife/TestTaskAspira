package com.aspira.ParserForAspira.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.List;

public class Jackson extends ObjectMapper {
    public <T> String serializeByInterface(List<? extends T> list, Class<T> tClass) {
        try {
            T[] t = list.toArray((T[]) Array.newInstance(tClass, 0));
            return writerFor(tClass.arrayType()).writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public <T> String serializeByInterface(T obj, Class<T> tClass) {
        try {
            return writerFor(tClass).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
