package com.hailintang.demo.geekbang.course09;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hailin.tang
 * @date 2020-03-29 20:50
 * @function
 */
public class TestDouble {
    @Test
    public void test1(){
        System.out.println(0.1+0.2);
        System.out.println(1.0-0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
    }

    @Test
    public void test2(){
        System.out.println(Long.numberOfLeadingZeros(7));
    }

    @Test
    public void test3(){
        // 加法
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
        // 
    }
}
