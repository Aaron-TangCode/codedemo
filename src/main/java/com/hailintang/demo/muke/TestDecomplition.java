package com.hailintang.demo.muke;

/**
 * @author hailin.tang
 * @date 2020/4/21 10:43 上午
 * @function
 */
public class TestDecomplition {
    static TestDecomplition testDecomplition = new TestDecomplition();
    static TestDecomplition instance = null;
    public static void main(String[] args) {
        testDecomplition.method01();
    }

    public void method01(){
        synchronized (instance){
            System.out.println("hello");
        }
    }

}
