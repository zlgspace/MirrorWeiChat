package com.zlgspace.mirrorweichat.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GsonUtil {
    private static Gson gson = new Gson();

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        try {
            return gson.fromJson(json, classOfT);
        } catch (JsonSyntaxException e) {
            throw new JsonSyntaxException(e);
        }
    }
}
