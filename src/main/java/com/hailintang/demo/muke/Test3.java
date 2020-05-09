package com.hailintang.demo.muke;

/**
 * @author hailin.tang
 * @date 2020/4/21 11:44 上午
 * @function
 */
public class Test3 implements Runnable{
    static Test3 test3 = new Test3();

    public synchronized void method1(){
        System.out.println("我是方法1"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法1执行结束"+Thread.currentThread().getName());
    }

    public synchronized void method2(){
        System.out.println("我是方法2"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法2执行结束"+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())){
            method1();
        }else{
            method2();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(test3);
        Thread t2 = new Thread(test3);
        t1.start();
        t2.start();
        while(t1.isAlive()||t2.isAlive()){

        }
        System.out.println("finished");
    }
}
