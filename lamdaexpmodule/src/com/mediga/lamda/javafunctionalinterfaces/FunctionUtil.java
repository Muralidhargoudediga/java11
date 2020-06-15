package com.mediga.lamda.javafunctionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//Think this class as a library which uses functional interfaces
public class FunctionUtil {
    // Applies an action on each item in a list
    public static <T> void forEach(List<T> list, Consumer<? super T> consumer) {
        for(T t : list) {
            consumer.accept(t);
        }
    }

    // Applies a filter to a list and returns the filtered list items
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for(T t : list) {
            if(predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    // Maps each item in a list to a value
    public static <T, R> List<R> map(List<T> list, Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for(T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }
}
