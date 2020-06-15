package com.mediga.lamda;

import java.util.function.IntFunction;

//Lambda expression does not support recursive invocations
public class RecursiveTest {
    public static void main(String[] args) {
        IntFunction<Long> intFunction = n -> factorial(n);
        IntFunction<Long> intFunction1 = RecursiveTest::factorial;
        System.out.println(intFunction.apply(5));
        System.out.println(intFunction1.apply(5));

        IntFunction<Long> factorialCalc = new IntFunction<Long>() { @Override
        public Long apply(int n) {
            if (n < 0) {
                String msg = "Number must not be negative.";
                throw new IllegalArgumentException(msg);
            }
            if (n == 0) { return 1L;
            } else {
                return n * this.apply(n - 1);
            } }
        };

        System.out.println(factorialCalc.apply(5));
    }

    public static long factorial(int n) {
        if (n < 0) {
            String msg = "Number must not be negative.";
            throw new IllegalArgumentException(msg);
        }
        if (n == 0) { return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
