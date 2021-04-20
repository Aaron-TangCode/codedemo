package com.hailintang.demo.jdk8.gc;

public class Demo {
    public void foo(){
        bar();
    }

    public void bar(){
        System.out.println("hhhhhhhhhhhhh");
    }

    public static void main(String[] args) {
//        Demo demo = new Demo();
//        demo.foo();
            String phone = "12345678901";
            boolean matches = phone.matches("^1[0-9]{10}$");
            System.out.println(matches);

            String num = "1234567890123456L";
        boolean matches1 = num.matches("^[0-9]{0,20}$");
        System.out.println(matches1);
    }
}
