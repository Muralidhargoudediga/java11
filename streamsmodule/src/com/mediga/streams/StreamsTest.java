package com.mediga.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        //SOme of the Ways to create streams
        Stream<String> s1 = Stream.of("a", "b", "c");

        //Using builder pattern
        Stream<String> s2 = Stream.<String>builder()
                                    .add("a")
                                    .add("b")
                                    .add("c")
                                    .build();


        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
        int sum = stream.filter(n -> n % 2 == 1)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum);
        System.out.println(sum);

        List<String> list = List.of("a", "b", "c");

        String result = list.stream()
                            .map(str -> str.toUpperCase())
                            .reduce("", String::concat);

        System.out.println(result);

        //Stream from chars() method in CharSequence
        String str = "5 apples and 25 oranges";
        str.chars()
                .filter(n -> !Character.isDigit((char)n) && !Character.isWhitespace((char)n))
                .forEach(n -> System.out.print((char)n));

        System.out.println();
        //Stream from splitAsStream() method in Pattern class
        String str1 = "Ken,Jeff,Lee";
        Pattern.compile(",")
                .splitAsStream(str1)
                .forEach(System.out::println);

    }
}
