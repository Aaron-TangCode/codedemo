package com.hailintang.demo.muke.corethreadknowledge.createthread;

/**
 * @author hailin.tang
 * @date 2020/5/1 12:37 上午
 * @function
 */
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();//实际调用targer.run()方法
    }
    @Override
    public void run() {
        System.out.println("i am coming");
    }
}
