package com.hailintang.demo.muke.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author hailin.tang
 * @date 2020/6/21 5:02 下午
 * @function 优点：运用装饰者模式，把缓存和计算解耦,没并发安全问题
 * 缺点：并发时，重复计算问题，用putIfAbsent来解决
 * 模拟计算出错，并且捕获异常，处理异常
 * 增加缓存过期时间
 * 测试性能
 */
public class ImoocCache10<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> map = new ConcurrentHashMap<>();
    private Computable<A, V> c;

    public ImoocCache10(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        while (true) {
            Future<V> f = map.get(arg);

            if (f == null) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<>(callable);
                f = map.putIfAbsent(arg, futureTask);
                if (f == null) {
                    f = futureTask;
                    System.out.println("从futureTask调用了计算函数");
                    futureTask.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                System.out.println("被取消了");
                map.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                System.out.println("被中断了");
                map.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                System.out.println("计算出错，重新计算");
                map.remove(arg);
            }
        }
    }

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
    public V compute(A arg,long expire) throws ExecutionException, InterruptedException {
        if(expire>0){
            executorService.schedule(()->{
                map.remove(arg);
                System.out.println("过期时间到，缓存被清除");
            },expire,TimeUnit.MILLISECONDS);
        }
        return compute(arg);
    }
    public static void main(String[] args) throws Exception {
        ImoocCache10<String,Integer> imoocCache10 =
                new ImoocCache10<>(new ComputeFunction());

        ExecutorService service = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();
        for (int i=0;i<100;i++){
            service.submit(()->{
                Integer compute = null;
                try {
                    compute = imoocCache10.compute("666");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(compute);
            });
        }
        service.shutdown();
        while(!service.isTerminated()){

        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}
