package com.mediga.streams;

import java.util.Random;
import java.util.stream.Stream;

public class InfiniteStreamTest {
    public static void main(String[] args) {
        Stream<Integer> nums = Stream.iterate(1, n -> n <= 1000, n -> n + 2);
        Stream<Long> naturalNumbers = Stream.iterate(1L, n -> n + 1);

        //This will keep on running
       // naturalNumbers.map(n -> n).forEach(System.out::println);

        //Use limit method to convert infinite stream to finite stream
        naturalNumbers.limit(10)
                .forEach(System.out::println);

        System.out.println();

        nums.limit(10)
                .forEach(System.out::println);

        System.out.println();

        Stream.iterate(2L, PrimeUtil::next)
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        Stream.iterate(2L, PrimeUtil::next)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);

        System.out.println();

        Stream.iterate(2L, PrimeUtil::next)
                .filter(n -> n > 3000)
                .limit(5)
                .forEach(System.out::println);

        //using generate() method
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(new PrimeUtil()::next)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);

        //Using Random class
        new Random().ints()
                    .limit(5)
                    .forEach(System.out::println);

    }
}
