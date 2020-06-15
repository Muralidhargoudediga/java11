package com.mediga.lamda;

@FunctionalInterface
public interface Joiner {
    String join(String s1, String s2);

    //You can Re-declare the public methods inherited from the Object class
    boolean equals(Object obj);
    int hashCode();

    //You can declare static and default methods in functional interfaces.
    default void test(){
        System.out.println("Joiner :: Default method");
    }

    static void test1() {
        System.out.println("Joiner :: Static method");
    }
}
