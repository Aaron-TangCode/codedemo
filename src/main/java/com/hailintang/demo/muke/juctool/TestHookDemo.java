package com.hailintang.demo.muke.juctool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020/6/10 8:53 下午
 * @function
 */
public class TestHookDemo {
    public static void main(String[] args) {
        TestHook hook = new TestHook(10,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        hook.execute(()->{
            System.out.println("测试钩子方法");
        });
    }
}
