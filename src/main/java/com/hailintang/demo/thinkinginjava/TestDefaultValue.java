package com.hailintang.demo.thinkinginjava;

/**
 * @author hailin.tang
 * @date 2020/5/8 7:57 下午
 * @function 测试八大基本类型的默认值
 */
public class TestDefaultValue {
    static int intValue;
    static byte byteValue;
    static short shortValue;
    static char charValue;
    static long longValue;
    static float floatValue;
    static double doubleValue;
    static boolean booleanValue;
    public static void main(String[] args) {
        System.out.println("int的默认值"+intValue);
        System.out.println("byte的默认值"+byteValue);
        System.out.println("short的默认值"+shortValue);
        System.out.println("char的默认值"+charValue);
        System.out.println("long的默认值"+longValue);
        System.out.println("float的默认值"+floatValue);
        System.out.println("double的默认值"+doubleValue);
        System.out.println("布尔的默认值"+booleanValue);
    }
}
