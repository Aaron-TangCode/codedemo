//package com.hailintang.demo.exception;
//
//import sun.tools.jconsole.ProxyClient;
//
//public class TestDemo1 implements AutoCloseable {
//    public static void main(String[] args) {
//        test();
//    }
//    public static int test(){
//         String name = "初始名字";
//        try {
//            int c = 1/0;
//            //tryblock
//            //finallyblock
//            name = "1";
//        } catch (Exception e) {
//            System.out.println("进入异常");
//            //catchblock
//            //finallyblock
//            //throw
//            name = "2";
//            try{
//                throw new RuntimeException("牛逼");
//            }catch (Exception e2){
//                throw new RuntimeException("牛逼牛逼2");
//            }
//        }finally {
//            System.out.println("你好呀");
//        }
//        return 1;//如果finally中有return，不会抛出异常。先执行finally语句，后执行throw语句，但是因为有return，没等抛出异常就退出了
//
//    }
//
//    @Override
//    public void close() throws Exception {
//        throw new RuntimeException("hahah");
//    }
//}
