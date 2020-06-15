package com.mediga.lamda;

import java.util.function.Consumer;

public class LamdaExamples {
    public static void main(String[] args) {
        Incrementor incrementor = (int x) -> x + 1;
        System.out.println(incrementor.increment(5));

        //Using modifiers for parameters
        Adder adder = (final double x, final double y) -> x + y;
        System.out.println(adder.add(10, 20));

        // Observe the following two lines. Same lamda expressin (x, y) -> x + y is used for both places,
        // but the target type of lamda is derived from the context. This type expression is called Poly expression.
        System.out.println(add((x, y) -> x + y, 30, 35));
        System.out.println(join((x, y) -> x + y, "abc", "def"));

        //Following statement gives ambiguous method call compile-time error. Uncomment to see full error message.
        //test((x, y) -> x + y);

        //This will work. Added casting
        test((Adder) (x, y) -> x + y);

        Maximum maximum = (x, y) -> {
            return x > y ? x : y;
        };

        System.out.println(maximum.max(20, 10));

        Consumer<String> consumer = (String msg) -> {
            System.out.println(msg);
        };

        consumer.accept("Java provided functional interface 'Consumer' test");

        printStringToIntMappingValue(str -> str.length(), "Test");
        printStringToIntMappingValue((str) -> {
            int mapping = 0;
            for(int i = 0; i < str.length(); i++) {
                mapping += str.charAt(i);
            }
            return mapping;
        }, "Test");

        //Using anonymous inner class instead of lamda expression
        printStringToIntMappingValue(new StringToIntMapper() {
            @Override
            public int map(String str) {
                return str.length();
            }
        }, "Test");

        //invoking default method of interface
        ((Joiner)(x, y) -> x + y).test();

        //invoking static method of interface
        Joiner.test1();
    }

    public static void printStringToIntMappingValue(StringToIntMapper mapper, String str) {
        System.out.println(mapper.map(str));
    }

    public static double add(Adder adder, double x, double y) {
        return adder.add(x, y);
    }

    public static String join(Joiner joiner, String s1, String s2) {
        return joiner.join(s1, s2);
    }

    static void test (Adder adder) {

    }

    static void test(Joiner joiner) {

    }
}
