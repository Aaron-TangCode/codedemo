package com.hailintang.demo.thinkinginjava;

/**
 * @author hailin.tang
 * @date 2020/7/30 7:13 下午
 * @function
 */
public class TestString {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));//因为b是被final修饰的，在编译期时，已经确定了值。
        // 所以用到b的地方，会直接用b的值来替换。因此c和a指向的是同一个地址
        System.out.println((a == e));
        System.out.println(d==b);//d和b的地址是一样的



            String a1 = "hello2";
            final String b1 = getHello();//即使b是被final修饰，但是在编译期不能确定b的值
            String c1 = b1 + 2;
            System.out.println((a1 == c1));
    }
    public static String getHello() {
        return "hello";
    }
}
