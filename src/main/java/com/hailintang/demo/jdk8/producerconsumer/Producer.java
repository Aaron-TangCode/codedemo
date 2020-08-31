package com.hailintang.demo.jdk8.producerconsumer;

/**
 * @author hailin.tang
 * @date 2020/8/30 5:34 下午
 * @function
 */
public class Producer implements Runnable {
    private Stroage stroage;

    public Producer(Stroage stroage) {
        this.stroage = stroage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            stroage.put(1);
        }
    }
}
