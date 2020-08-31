package com.hailintang.demo.spring;

/**
 * @author hailin.tang
 * @date 2020/5/24 1:48 下午
 * @function
 */
public class TransferServiceImpl implements TransferService{
    @Override
    public void transfer() {
        System.out.println("transfer方法调用成功");
    }

    public static void main(String[] args) {
        System.out.println("67ff8bad4026b3e3".hashCode()%32);
    }
}
