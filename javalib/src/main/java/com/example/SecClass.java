package com.example;

import java.io.Serializable;

/**
 * Created by chenyu on 16/7/5.
 */
public class SecClass implements Serializable{
    static int val = 0;

    public interface UnaryFunction<T> {
        T apply(T arg);
    }

    private static UnaryFunction<Object> IDENTY = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> idenFunction() {
        return (UnaryFunction<T>) IDENTY;
    }

 }
