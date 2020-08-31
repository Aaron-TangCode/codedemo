package com.hailintang.demo.spring;

/**
 * @author hailin.tang
 * @date 2020/5/24 1:34 下午
 * @function
 */
//@Component
public class MyServiceImpl implements MyService{
    @Override
    public void doStuff() {
        System.out.println("测试bean方法");
    }
    @Override
    public void init(){
        System.out.println("初始化完成");
    }
    @Override
    public void des(){
        System.out.println("销毁完成");
    }
}
