package com.hailintang.demo.muke.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020/6/21 4:59 下午
 * @function
 */
public class MayFail implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws Exception {
        if (Math.random() > 0.5) {
            throw new IOException();
        }
        TimeUnit.SECONDS.sleep(5);
        return Integer.valueOf(arg);
    }
}
