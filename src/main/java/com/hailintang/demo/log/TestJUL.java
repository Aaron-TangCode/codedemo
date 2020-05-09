package com.hailintang.demo.log;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

/**
 * @author hailin.tang
 * @date 2020-04-07 20:55
 * @function
 */
public class TestJUL {
    @Test
    public void test1(){
        Logger logger = Logger.getLogger("com.hailintang.demo.log.TestJUL");
        logger.info("hello jul");

        //日志级别
        logger.log(Level.INFO,"HELLO INFO");

        //占位符
        String name = "Aaron";

        int age = 23;

        logger.log(Level.INFO,"名字：{}",new Object());
        logger.log(Level.INFO,"用户信息：{0},{1}",new Object[]{name,age});
    }

    @Test
    public void test2(){
        //输出不同级别的日志，默认的级别是info
        Logger logger = Logger.getLogger("com.hailintang.demo.log.TestJUL");
        logger.log(Level.SEVERE,"severe");
        logger.log(Level.WARNING,"warn");
        logger.log(Level.INFO,"info");
        logger.log(Level.CONFIG,"config");
        logger.log(Level.FINE,"fine");
        logger.log(Level.FINER,"finer");
        logger.log(Level.FINEST,"finest");
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test3(){
        Logger logger = Logger.getLogger("com.hailintang.demo.log.TestJUL");

        //创建handler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建formatter
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // consoleHandler和formatter关联
        consoleHandler.setFormatter(simpleFormatter);

        // logger和handler关联
        logger.addHandler(consoleHandler);

        // 关闭系统默认配置
        logger.setUseParentHandlers(false);

        // 设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger.log(Level.SEVERE,"severe");
        logger.log(Level.WARNING,"warn");
        logger.log(Level.INFO,"info");
        logger.log(Level.CONFIG,"config");
        logger.log(Level.FINE,"fine");
        logger.log(Level.FINER,"finer");
        logger.log(Level.FINEST,"finest");
    }

    @Test
    public void test4(){
        Logger logger1 = Logger.getLogger("com.hailintang.demo.log");
        Logger logger2 = Logger.getLogger("com.hailintang.demo");

        ConsoleHandler consoleHandler = new ConsoleHandler();

        SimpleFormatter simpleFormatter = new SimpleFormatter();

        consoleHandler.setFormatter(simpleFormatter);

        logger2.setUseParentHandlers(false);
        logger2.addHandler(consoleHandler);

        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        System.out.println(logger1.getParent()==logger2);
        System.out.println(logger1.getParent().getName());
        System.out.println(logger2.getParent());
        logger1.log(Level.SEVERE,"severe");
        logger1.log(Level.WARNING,"warn");
        logger1.log(Level.INFO,"info");
        logger1.log(Level.CONFIG,"config");
        logger1.log(Level.FINE,"fine");
        logger1.log(Level.FINER,"finer");
        logger1.log(Level.FINEST,"finest");

    }

    @Test
    public void test5() throws IOException {
        InputStream ins = TestJUL.class.getClassLoader().getResourceAsStream("logging.properties");

        //创建LogManager
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(ins);

        Logger logger = Logger.getLogger("com.hailintang.demo.log");


        logger.log(Level.SEVERE,"severe");
        logger.log(Level.WARNING,"warn");
        logger.log(Level.INFO,"info");
        logger.log(Level.CONFIG,"config");
        logger.log(Level.FINE,"fine");
        logger.log(Level.FINER,"finer");
        logger.log(Level.FINEST,"finest");
    }
}
