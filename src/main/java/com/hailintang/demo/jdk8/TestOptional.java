package com.hailintang.demo.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author hailin.tang
 * @date 2020-03-25 17:00
 * @function
 */
public class TestOptional {
    @Test
    public void test1(){
        /**
         * 创建optional的三种方法：
         * Optional.of(T t),t必须非空
         * Optional.emplt(),创建一个空的optional
         * Optional.ofNullable(T t),t是否为空都行
         */
        Girl girl = new Girl();
        girl = null;
//        Optional<Girl> girl1 = Optional.of(girl);
        Optional.ofNullable(girl);
    }
}
