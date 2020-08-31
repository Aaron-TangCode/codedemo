package com.hailintang.demo.muke.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020/6/21 4:59 下午
 * @function
 */
public class ComputeFunction implements Computable<String,Integer> {
    @Override
    public Integer compute(String arg) throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return Integer.valueOf(arg);
    }
}
