package com.hailintang.demo.muke.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020/6/21 5:02 下午
 * @function
 * 优点：运用装饰者模式，把缓存和计算解耦
 * 缺点：有并发安全问题
 */
public class ImoocCache2<A,V> implements Computable<A,V> {
    private final Map<A,V> map = new HashMap<>();
    private Computable<A,V> c;

    public ImoocCache2(Computable<A,V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        V result = map.get(arg);
        if(result == null){
            result = c.compute(arg);
            map.put(arg,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache2<String,Integer> imoocCache2 =
                new ImoocCache2<>(new ComputeFunction());

        Integer result = imoocCache2.compute("666");

        System.out.println("the first result = "+result);

        Integer result2 = imoocCache2.compute("666");

        System.out.println("the second result ="+result2);

    }
}
