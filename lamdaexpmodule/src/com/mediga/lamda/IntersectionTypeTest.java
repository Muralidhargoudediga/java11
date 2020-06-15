package com.mediga.lamda;

import java.io.*;

public class IntersectionTypeTest {
    public static void main(String[] args) throws Exception {
        Serializable ser = (Serializable & Adder) (x, y) -> x + y;
        System.out.println(LamdaExamples.add((Adder)ser, 10, 20));

        var joiner = (Serializable & Joiner) (x, y) -> x + " " + y;
        System.out.println(LamdaExamples.join(joiner, "abc", "def"));

        //You can pass class A instance to test method as it is implementing both Serializable and AutoCloseable
        test(new A());

        //You cannot pass class B instance to test method as it is not implementing Serializable
        //test(new B());
    }

    //Intersection typ using Generics
    static <T extends Serializable & AutoCloseable> void test(T t) throws Exception {
        try(t) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ser"));
            oos.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class A implements Serializable, AutoCloseable {

    @Override
    public void close() throws Exception {

    }
}

class B implements AutoCloseable {

    @Override
    public void close() throws Exception {

    }
}