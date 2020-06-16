package com.mediga.streams;

import java.util.stream.IntStream;

public class PeekTest {
    public static void main(String[] args) {
        //Use peek() method for debugging purposes
        int sum = IntStream.of(1, 2, 3, 4, 5)
                            .peek(e -> System.out.println("Taking Integer " + e))
                            .filter(n -> n % 2 == 1)
                            .peek(e -> System.out.println("Filtered Integer " + e))
                            .map(n -> n * n)
                            .peek(e -> System.out.println("Mapped Inetger " + e))
                            .reduce(0, Integer::sum);

        System.out.println("Sum " + sum);
    }
}
