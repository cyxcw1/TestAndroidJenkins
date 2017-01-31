package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyClass {

    public static class ArrayMaker<T> {
        private Class<T> type;

        public ArrayMaker(Class<T> type) {
            this.type = type;
        }

        @SuppressWarnings("unchecked")
        T[] createArray(int size) {
            return (T[]) Array.newInstance(type, size);
        }

        List<T> createList() {
            return new ArrayList<T>();
        }
    }

    class Type {
        @Override
        public String toString() {
            return "type";
        }
    }

    class Generic<T> {
        @Override
        public String toString() {
            return "Generic";
        }
    }

    public static class ArrayOfGeneric2<T> {
        public T[] ts;

        public ArrayOfGeneric2(int size) {
            ts = (T[]) new Object[size];
        }

        public T get(int index) {
            return ts[index];
        }

        public T[] rep() {
            return ts;
        }

        public void set(int index, T t) {
            ts[index] = t;
        }

    }

    public static class ArrayOfGeneric3<T> {
        Object[] ts;

        public ArrayOfGeneric3(int size) {
            ts = new Object[size];
        }

        public T get(int index) {
            return (T) ts[index];
        }

        public T[] rep() {
            return (T[]) ts;
        }

        public void set(int index, T t) {
            ts[index] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SecClass.val = 3;
        SecClass so = new SecClass();

        ArrayMaker<Type> am2 = new ArrayMaker<Type>(Type.class);
        System.out.println(Arrays.asList(am2.createArray(10)));
        System.out.println(Arrays.asList(am2.createList()));

        Generic<Integer>[] genArr;
//        genArr = (Generic<Integer>[]) new Generic<Integer>[2];
//        genArr = (Generic<Integer>[]) new Object[] {};
        genArr = (Generic<Integer>[]) new Generic[2];
        System.out.println(genArr);

        ArrayOfGeneric2<String> aog2 = new ArrayOfGeneric2<String>(10);
        Object[] objs = aog2.rep();
        System.out.println(objs);
//
//        String[] strs = aog2.rep();
//        System.out.println(strs);
        ArrayOfGeneric3<Integer> aog3 = new ArrayOfGeneric3<Integer>(10);
        Object[] objs2 = aog3.rep();
        for (int i = 0; i < 10; i++) {
            aog3.set(i, i);
            System.out.println(aog3.get(i));
        }
//        Integer[] strs = aog3.rep();
//        System.out.println(strs);

//        Object[] objectArr = new Long[1];
//        objectArr[0] = "I don't fit it";

        ArrayList<?>[] stringList = new ArrayList<?>[1];
        stringList[0] = new ArrayList<String>();

        if(stringList[0] instanceof List) {
            ((ArrayList<Integer>)stringList[0]).add(1);
        }
        ((ArrayList<String>)stringList[0]).add("stttttt");

        System.out.println(stringList[0].get(1));
        System.out.println(stringList[0].get(0));


        Set<Integer> si = new HashSet<>();


    }

//    static Object reduce(List list, Function f, Object initVal){
//        synchronized (list) {
//            Object result = initVal;
//            for(Object o : list) {
//                result = f.apply(result, o);
//
//            }
//            return result;
//        }
//    }

    static Object reduce(List list, Function f, Object initVal) {
        Object[] snap = list.toArray();
        Object result = initVal;
        for (Object o : snap) {
            result = f.apply(result, o);

        }
        return result;
    }

    interface Function{
        Object apply(Object arg1, Object arg2);
    }

}
