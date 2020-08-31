package com.hailintang.demo.muke.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hailin.tang
 * @date 2020/6/21 5:02 下午
 * @function 优点：运用装饰者模式，把缓存和计算解耦,没并发安全问题
 * 缺点：并发时，重复计算问题
 */
public class ImoocCache5<A, V> implements Computable<A, V> {
    private final Map<A, V> map = new ConcurrentHashMap<>();
    private Computable<A, V> c;

    public ImoocCache5(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        V result = map.get(arg);
        if (result == null) {
            synchronized (this) {
                result = c.compute(arg);
                map.put(arg, result);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache5<String, Integer> imoocCache2 =
                new ImoocCache5<>(new ComputeFunction());

        Integer result = imoocCache2.compute("666");

        System.out.println("the first result = " + result);

        Integer result2 = imoocCache2.compute("666");

        System.out.println("the second result =" + result2);

    }
}
