package com.hailintang.demo.muke.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailin.tang
 * @date 2020/6/21 5:02 下午
 * @function 
 * 优点：运用装饰者模式，把缓存和计算解耦
 * 缺点：有并发安全问题，用synchronized解决安全问题，但性能差
 */
public class ImoocCache3<A,V> implements Computable<A,V> {
    private final Map<A,V> map = new HashMap<>();
    private Computable<A,V> c;

    public ImoocCache3(Computable<A,V> c) {
        this.c = c;
    }

    @Override
    public synchronized V  compute(A arg) throws Exception {
        V result = map.get(arg);
        if(result == null){
            result = c.compute(arg);
            map.put(arg,result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache3<String,Integer> imoocCache3 =
                new ImoocCache3<>(new ComputeFunction());

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
                result2 = imoocCache3.compute("667");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("the second result ="+result2);
        }).start();

        new Thread(()->{
            Integer result2 = null;
            try {
                result2 = imoocCache3.compute("666");
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("the third result ="+result2);
        }).start();



    }
}
