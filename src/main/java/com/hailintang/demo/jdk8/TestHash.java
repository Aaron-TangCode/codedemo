package com.hailintang.demo.jdk8;

public class TestHash {
    public static int getHashCode(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        while(true){
            int num = getHashCode(new Object());
            if(num<0){
                System.out.println(num);
                break;
            }else{
                System.out.println(num);
            }
        }
    }
}
