package com.hailintang.demo.muke.corethreadknowledge.createthread;

/**
 * @author hailin.tang
 * @date 2020/5/1 12:47 上午
 * @function 同时有runnable和thread会怎样？会运行thread，因为run方法已经被重写了，target.run()已经被覆盖了
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am runnable");
            }
        }){
            @Override
            public void run(){
                System.out.println("i am thread");
            }
        }.start();
    }
}
