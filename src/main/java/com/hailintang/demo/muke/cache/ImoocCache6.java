package com.hailintang.demo.muke.cache;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author hailin.tang
 * @date 2020/6/21 5:02 下午
 * @function 优点：运用装饰者模式，把缓存和计算解耦,没并发安全问题
 * 缺点：并发时，重复计算问题
 */
public class ImoocCache6<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> map = new ConcurrentHashMap<>();
    private Computable<A, V> c;

    public ImoocCache6(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        Future<V> f = map.get(arg);
        if(f==null){
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> futureTask = new FutureTask<>(callable);
            f = futureTask;
            map.put(arg,futureTask);
            System.out.println("从futureTask调用了计算函数");
            futureTask.run();
        }
        return f.get();
    }

    public static void main(String[] args) throws Exception {
        ImoocCache6<String, Integer> imoocCache3 =
                new ImoocCache6<>(new ComputeFunction());

        new Thread(()->{
            Integer result = null;
            try {
                result = imoocCache3.compute("666");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("the first result = "+result);

        }).start();
        new Thread(()->{
            Integer result2 = null;
            try {
                result2 = imoocCache3.compute("666");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("the second result ="+result2);
        }).start();

        new Thread(()->{
            Integer result2 = null;
            try {
                result2 = imoocCache3.compute("667");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("the third result ="+result2);
        }).start();

    }
}
