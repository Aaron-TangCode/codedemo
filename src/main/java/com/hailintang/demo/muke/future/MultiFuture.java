package com.hailintang.demo.muke.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author hailin.tang
 * @date 2020/6/20 5:31 下午
 * @function
 */
public class MultiFuture {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        List<Future> futureList = new ArrayList<>();
        Callable<Integer> callable = ()->{
            Thread.sleep(3000);
            return new Random().nextInt();
        };

        for (int i=0;i<20;i++){
            Future<Integer> future = service.submit(callable);
            futureList.add(future);

        }

        for(int i=0;i<20;i++){
            try {
                System.out.println(Thread.currentThread().getName()+i+":"+futureList.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        service.shutdown();
    }
}
