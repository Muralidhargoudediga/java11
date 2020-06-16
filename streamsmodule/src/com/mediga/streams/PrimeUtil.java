package com.mediga.streams;

public class PrimeUtil {
    private long lastPrime = 0L;

    public long next() {
        lastPrime = next(lastPrime);

        return lastPrime;
    }

    public static long next(long after) {
        long counter = after;

        // Keep looping until you find the next prime number
        while(!isPrime(++counter));

        return counter;
    }

    public static boolean isPrime(long number) {
        if(number <= 1){
            return false;
        }

        if(number == 2) {
            return true;
        }

        if(number % 2 == 0) {
            return false;
        }

        long maxDivisor = (long) Math.sqrt(number);
        for (int i = 3; i <= maxDivisor; i += 2 ){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
