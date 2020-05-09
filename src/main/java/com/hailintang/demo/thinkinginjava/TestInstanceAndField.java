package com.hailintang.demo.thinkinginjava;

/**
 * @author hailin.tang
 * @date 2020/5/8 7:51 下午
 * @function
 */
public class TestInstanceAndField {
    int field1 = 1;
    String field2 = "a";

    public static void main(String[] args) {
        TestInstanceAndField obj1 = new TestInstanceAndField();
        TestInstanceAndField obj2 = new TestInstanceAndField();
        System.out.println("对象1的field1="+obj1.field1);
        System.out.println("对象2的field1="+obj2.field1);
        //修改对象1的field1值
        obj1.field1 = 2;
        System.out.println("对象1的field1="+obj1.field1);
        System.out.println("对象2的field1="+obj2.field1);

        System.out.println();

        System.out.println("对象1的field2="+obj1.field2);
        System.out.println("对象2的field2="+obj2.field2);
        //修改对象2的field2值
        obj2.field2 = "b";
        System.out.println("对象1的field2="+obj1.field2);
        System.out.println("对象2的field2="+obj2.field2);
    }
}
