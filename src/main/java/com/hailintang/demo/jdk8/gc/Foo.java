package com.hailintang.demo.jdk8.gc;

public class Foo {
  static boolean boolValue;
  public static void main(String[] args) {
    boolValue = true; // 将这个true替换为2或者3，再看看打印结果。2会打印Hello, Java!----3会两个都打印，因为3的二进制是11，取最后一位
    if (boolValue) System.out.println("Hello, Java!");
    if (boolValue == true) System.out.println("Hello, JVM!");
  }
}