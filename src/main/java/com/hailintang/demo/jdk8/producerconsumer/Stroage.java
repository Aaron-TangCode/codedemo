package com.hailintang.demo.jdk8.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailin.tang
 * @date 2020/8/30 5:56 下午
 * @function
 */
public class Stroage {
    private int maxSize;
    private List<Integer> list;

    public Stroage() {
        this.maxSize = 10;
        this.list = new ArrayList<>();
    }


    public synchronized void put(Integer e){
        while(list.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        list.add(e);
        notify();
        System.out.println("生产果子，目前有"+list.size()+"个果子");
    }

    public synchronized void get(){
        while(list.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        notify();
        System.out.println("消费产品，剩下产品"+list.size()+"个");
    }
}
