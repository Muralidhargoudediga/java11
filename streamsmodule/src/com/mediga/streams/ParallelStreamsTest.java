package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamsTest {
    public static void main(String[] args) {

        //Check the output for number of threads

        System.out.println("Serial processing of stream...");
        Person.persons()
                .stream()
                .filter(p -> {
                    System.out.println("Filtering " + p + " by " + Thread.currentThread().getName());
                    return p.isMale();
                }).forEach(p -> {
            System.out.println(Thread.currentThread().getName() + " :: " + p);
        });

        System.out.println();
        System.out.println("Parallel processing of stream....");

        Person.persons()
                .parallelStream()
                .filter(p -> {
                    System.out.println("Filtering " + p + " by " + Thread.currentThread().getName());
                    return p.isMale();
                }).forEach(p -> {
            System.out.println(Thread.currentThread().getName() + " :: " + p);
        });

        //Time difference when stream data is large
        System.out.println("Serial processing...");
        long startTime = System.currentTimeMillis();
        long count = IntStream.rangeClosed(1, Integer.MAX_VALUE / 10)
                .filter(PrimeUtil::isPrime)
                .count();
        long endTime = System.currentTimeMillis();
        //Took 491 seconds on MacBook Pro 8-core Intel Core i9 processor
        System.out.println("Time took for serial processing :: " + (endTime - startTime) / 1000 + " seconds");

        System.out.println("Parallel processing...");
        startTime = System.currentTimeMillis();
        count = IntStream.rangeClosed(1, Integer.MAX_VALUE / 10)
                .parallel()
                .filter(PrimeUtil::isPrime)
                .count();
        endTime = System.currentTimeMillis();
        //Took 59 seconds on MacBook Pro 8-core Intel Core i9 processor
        System.out.println("Time took for parallel processing :: " + (endTime - startTime) / 1000 + " seconds");
    }
}
