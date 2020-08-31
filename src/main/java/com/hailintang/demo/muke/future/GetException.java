package com.hailintang.demo.muke.future;

import java.util.concurrent.*;

/**
 * @author hailin.tang
 * @date 2020/6/20 5:41 下午
 * @function
 */
public class GetException {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        Callable<Integer> callable = () -> {
            throw new IllegalAccessException();

        };
        Future<Integer> future = service.submit(callable);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("发生了InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("发生了ExecutionException");
            e.printStackTrace();
        }

        service.shutdown();
    }
}
