package com.hailintang.demo.muke.corethreadknowledge.producerconsumerstyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hailin.tang
 * @date 2020/5/18 8:28 下午
 * @function
 */
public class Storage {
    private int maxSize;

    private List<Integer> list;


    public Storage() {
        this.maxSize = 10;
        this.list = new ArrayList<>();
    }

    public synchronized void put(Integer num){
        while (list.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(num);
        notify();
        System.out.println("生产者成功生产："+list.size()+"个产品");
    }

    public synchronized void take(){
        while(list.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println("消费者成功消费,剩余"+list.size()+"个产品");
        notify();
    }
}
