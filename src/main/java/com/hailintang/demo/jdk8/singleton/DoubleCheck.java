package com.hailintang.demo.jdk8.singleton;

/**
 * @author hailin.tang
 * @date 2020/8/30 9:42 下午
 * @function
 */
public class DoubleCheck {
    private static volatile DoubleCheck instance;

    private DoubleCheck() {
    }

    ;

    public static DoubleCheck getInstance() {
        //第一个检测是：提高效率
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                //第一个检测是为了安全
                if (instance == null) {
                    instance = new DoubleCheck();
                }

            }
        }
        return instance;
    }
}
