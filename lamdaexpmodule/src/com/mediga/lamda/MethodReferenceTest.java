package com.mediga.lamda;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class MethodReferenceTest implements C{

    public static void main(String[] args) {
        ToIntFunction<String> toIntFunction1 = str -> str.length();

        //Using method reference
        ToIntFunction<String> toIntFunction2 = String::length;

        System.out.println(toIntFunction1.applyAsInt("Test"));
        System.out.println(toIntFunction2.applyAsInt("Test"));

        String str = "Test"; //Effectively final. Means initialized only once
        //str = "";
        Supplier<Integer> supplier1 = () -> str.length();
        Supplier<Integer> supplier2 = str::length;

        new MethodReferenceTest().test();
    }

    //Supertype Instance Method References
    void test(){
        Supplier<String> s1 = this::toString;
        Supplier<String> s2 = super::toString;
        Supplier<String> s3 = this::show;
        //Super Interface instance method reference
        Supplier<String> s4 = C.super::show;

        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
        System.out.println(s4.get());
    }

    @Override
    public String toString() {
        return "MethodReferenceTest{}";
    }

    @Override
    public String show(){
        return "Class MethodReferenceTest";
    }
}

interface C {
    default String show(){
        return "Interface A";
    }
}
