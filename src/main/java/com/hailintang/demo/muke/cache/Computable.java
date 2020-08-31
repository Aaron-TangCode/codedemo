package com.hailintang.demo.muke.cache;

/**
 * @author hailin.tang
 * @date 2020/6/21 4:58 下午
 * @function
 */
public interface Computable<A,V> {
    V compute(A arg) throws Exception;
}
