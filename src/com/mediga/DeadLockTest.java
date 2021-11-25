package com.mediga;

public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(() -> a.foo(b));
        Thread t2 = new Thread(() -> b.foo(a));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class A {
    synchronized void foo(B b) {
        System.out.println("A.foo()");
        b.bar();
    }
    synchronized void bar() {
        System.out.println("A.bar()");
    }
}

class B {
    synchronized void foo(A a) {
        System.out.println("B.foo()");
        a.bar();
    }

    synchronized void bar() {
        System.out.println("B.bar()");
    }
}
