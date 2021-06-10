package com.hailintang.demo.jdk8.string;

public class Demo1 {
        static int a = 1;

        static String b = "abc123";

        public static void main(String[] args) {

            String bb = b.substring(b.length() -1);


            System.out.println(b.substring(3,5));
            System.out.println(a + " " + bb);

            p();
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
//        b[1] = Integer.valueOf(42);
        b[1] = String.valueOf("42");
    }

    public static void p() {
        Number[] a  = new Integer[2];

        a[0] = 1.0;

    }
}
