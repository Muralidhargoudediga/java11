package com.mediga.streams;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalValue {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        Optional<String> str = Optional.of("Test");
        String s = null;
        Optional<String> nullableStr = Optional.ofNullable(s);

        System.out.println(empty.isEmpty());

        if(str.isPresent()) {
            System.out.println(str.get());
        }

        //Use this method to perform some action on value of the Optional
        str.ifPresent(s1 -> System.out.println(s1));

        System.out.println(nullableStr.isEmpty());

        System.out.println(nullableStr.orElse("Return this if empty"));
        System.out.println(nullableStr.orElseGet(() -> "Get value from Supplier"));
        //Throw an exception if non-value is not present
        //System.out.println(nullableStr.orElseThrow(() -> new NoSuchElementException()));

        OptionalInt maxOdd = IntStream.of(10, 20, 30)
                                        .filter(n -> n % 2 == 1)
                                        .max();
        if(maxOdd.isPresent()) {
            System.out.println("Max odd value " + maxOdd.getAsInt());
        } else {
            System.out.println("No odd numbers in the stream");
        }

        maxOdd = IntStream.of(1, 9, 10, 23, 30, 45)
                    .filter(n -> n % 2 == 1)
                    .max();

        if(maxOdd.isPresent()) {
            System.out.println("Max odd value " + maxOdd.getAsInt());
        } else {
            System.out.println("No odd numbers in the stream");
        }

        Optional<String> name = Stream.of("ab", "abcd", "abc")
                                        .max(Comparator.comparing(String::length));

        if(name.isPresent()) {
            System.out.println("Max Length Name is " + name.get());
        } else {
            System.out.println("Stream is empty");
        }

    }
}
