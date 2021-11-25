package com.mediga.lamda;

public class Test22 {
    static {
        System.out.println("Test22");
    }
    public static void main(String[] args) {
        A11 a = new A11();
        A11.D d = a.new D();
        d.d();
        d.c();
    }
}

class A11 {
    static int a = 10;
    static {
        System.out.println("A11");
        a = 1;
    }

   static void a() {
        System.out.println( a );
   }

   class C {
        void c() {
            System.out.println("C");
        }
   }
    class D extends C{
        void d() {
            System.out.println("D");
        }
    }
}
