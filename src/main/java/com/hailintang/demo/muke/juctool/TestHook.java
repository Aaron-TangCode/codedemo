package com.hailintang.demo.muke.juctool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020/6/10 8:51 下午
 * @function
 */
public class TestHook extends ThreadPoolExecutor {
    public TestHook(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println(t.getName()+"执行任务前");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("执行任务后");
    }
}
