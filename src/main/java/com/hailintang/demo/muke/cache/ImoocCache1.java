package com.hailintang.demo.muke.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author hailin.tang
 * @date 2020/6/21 4:35 下午
 * @function
 */
public class ImoocCache1 {
    //属性被声明为final后，只能被赋值一次。增强安全性
    private  final Map<String, Integer> cache = new HashMap<>();


    public Integer compute(String userId) throws InterruptedException {
        Integer result = cache.get(userId);
        if (result == null) {
            result = doCompute(userId);
            cache.put(userId,result);
        }
        return result;
    }

    private Integer doCompute(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return Integer.valueOf(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        ImoocCache1 imoocCache1 = new ImoocCache1();
        Integer result = imoocCache1.compute("13");
        System.out.println("第一次计算的结果："+result);
        Integer result2 = imoocCache1.compute("13");
        System.out.println("第二季计算的结果："+result2);
    }
}
