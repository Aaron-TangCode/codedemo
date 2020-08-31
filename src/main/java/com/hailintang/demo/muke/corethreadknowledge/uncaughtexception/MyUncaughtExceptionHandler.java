package com.hailintang.demo.muke.corethreadknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author hailin.tang
 * @date 2020/5/19 9:49 下午
 * @function
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,()->{return "发生异常啦"+t.getName()+"异常信息："+e;});

        System.out.println("未捕获异常"+name+"捕获了异常");
    }
}
