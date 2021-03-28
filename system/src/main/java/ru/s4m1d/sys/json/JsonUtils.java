package ru.s4m1d.sys.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    public static String getJsonFromObject(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(object);
        return json;
    }

    public static Object getObjectFromJson(String json, Class<?> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object object = objectMapper.readValue(json,cls);
        return object;
    }
}
