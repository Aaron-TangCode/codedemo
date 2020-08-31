package com.hailintang.demo.jdk8.producerconsumer;

/**
 * @author hailin.tang
 * @date 2020/8/30 5:47 下午
 * @function
 */
public class Consumer implements Runnable {

    private Stroage stroage;

    public Consumer(Stroage stroage) {
        this.stroage = stroage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            stroage.get();
        }
    }
}
