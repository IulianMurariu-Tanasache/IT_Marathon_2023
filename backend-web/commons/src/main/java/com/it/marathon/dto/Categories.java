package com.it.marathon.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categories {
    DANGEROUS,
    LOST,
    GARBAGE,
    OTHER;

    @JsonCreator
    public static Categories fromString(String key) {
        return key == null
                ? null
                : Categories.valueOf(key.toUpperCase());
    }

//    @JsonValue
//    public String getKey() {
//        return key;
//    }
}
