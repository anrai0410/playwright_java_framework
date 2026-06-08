package com.aditya.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectRepository {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ObjectRepository.class.getClassLoader().getResourceAsStream("object-repository.properties")) {
            if (input == null) {
                throw new RuntimeException("object-repository.properties not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load object-repository.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Selector not found for key: " + key);
        }
        return value;
    }

    public static String get(String key, Object... args) {
        return String.format(get(key), args);
    }
}
