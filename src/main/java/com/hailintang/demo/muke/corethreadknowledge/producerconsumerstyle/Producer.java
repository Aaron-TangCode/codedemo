package com.hailintang.demo.muke.corethreadknowledge.producerconsumerstyle;

/**
 * @author hailin.tang
 * @date 2020/5/18 8:27 下午
 * @function
 */
public class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            storage.put(i);
        }
    }
}
