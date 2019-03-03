package com.wj.demo.utils;

import java.util.function.Consumer;

public class QueryUtil {


    public static void notNull(Object obj, Consumer<Object> function) {
        if (obj == null) return;
        function.accept(obj);
    }

    public static void notEmpty(String obj, Consumer<String> function) {
        if (obj == null || obj.isEmpty()) return;
        function.accept(obj);
    }

    public static void notZero(Double obj, Consumer<Double> function) {
        if (obj == null || obj == 0) return;
        function.accept(obj);
    }

    public static void notZero(Integer obj, Consumer<Integer> function) {
        if (obj == null || obj == 0) return;
        function.accept(obj);
    }

    public static void notZero(Long obj, Consumer<Long> function) {
        if (obj == null || obj == 0) return;
        function.accept(obj);
    }
}
