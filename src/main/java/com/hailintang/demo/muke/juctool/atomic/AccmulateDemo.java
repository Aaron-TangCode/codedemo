package com.hailintang.demo.muke.juctool.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * @author hailin.tang
 * @date 2020/6/14 12:57 上午
 * @function
 */
public class AccmulateDemo {
    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator(
                (x,y)->{return x*y;}
        ,1);//identity是x的初始值，x*y 就是 y=x*y;
        IntStream.range(1,10).forEach(
                x->{
                    longAccumulator.accumulate(x);
                }
        );
        System.out.println(longAccumulator.get());


    }
}
