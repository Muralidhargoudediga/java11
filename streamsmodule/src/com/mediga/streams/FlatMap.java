package com.mediga.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        //Create a stream containing the numbers in the input stream and their squares
        //Using map() method - wrong way

        Stream.of(1, 2, 3)
                .map(n -> Stream.of(n, n * n))
                .forEach(System.out::println);

        //Using map() method - right way
        Stream.of(1, 2, 3)
                .map(n -> Stream.of(n, n * n))
                .forEach(s -> s.forEach(System.out::println));

        System.out.println();
        //Using flatMap() method - Better and easy way
        Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n* n))
                .forEach(System.out::println);

        //Count number of e's in all strings in the stream
        long count = Stream.of("Men", "Women", "Other", "GENDER")
                            .flatMapToInt(str -> str.chars())
                            .mapToObj(n -> (char)n)
                            .filter(ch -> ch == 'e' || ch == 'E')
                            .count();

        System.out.println("E's count " + count);

        //Another way - using different pipeline
        count = Stream.of("Men", "Women", "Other", "GENDER")
                            .map(str -> str.chars())
                            .flatMap(s -> s.mapToObj(c -> (char)c))
                            .filter(ch -> ch == 'e' || ch == 'E')
                            .count();

        System.out.println("E's count " + count);
    }
}
