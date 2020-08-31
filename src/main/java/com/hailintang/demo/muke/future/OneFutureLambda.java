package com.hailintang.demo.muke.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author hailin.tang
 * @date 2020/6/20 5:24 下午
 * @function
 */
public class OneFutureLambda {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Callable<Integer> callable = ()->{
            Thread.sleep(3000);
            return new Random().nextInt();
        };
        Future<Integer> future = service.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
