package com.hailintang.demo.bloomFilter;

import java.util.BitSet;

/**
 * @author hailin.tang
 * @date 2020/4/20 5:34 下午
 * @function
 */
public class TestBloomFilter {
    private static final int DEFAULT_SIZE= 2<< 25;
    BitSet bitSet = new BitSet(DEFAULT_SIZE);
    int[] seeds = new int[]{1,3,5};
    HashFuns[] hashFuns = new HashFuns[seeds.length];
    /**
     * 布隆过滤器
     * 1、准备N个哈希函数
     * 2、根据不同的种子，生成不同的哈希函数
     * 3、根据N个哈希函数生成的值index,数组中的index位置标记为1
     */
    public static void main(String[] args) {
        String str = "tanghailin";
        //根据种子生成不同的哈希函数
        TestBloomFilter testBloomFilter = new TestBloomFilter();
        System.out.println(testBloomFilter.contains(str));
        testBloomFilter.add(str);
        System.out.println(testBloomFilter.contains(str));

    }

    public TestBloomFilter(){
        for(int i=0;i<seeds.length;i++){
            hashFuns[i] = new HashFuns(DEFAULT_SIZE,seeds[i]);
        }
    }

    public void add(String value){
        for (int i = 0; i < seeds.length; i++) {
            bitSet.set(hashFuns[i].hash(value));
        }
    }
    public boolean contains(String value){
        boolean flag = true;
        for (int i=0;i<seeds.length;i++){
            flag = flag&&bitSet.get(hashFuns[i].hash(value));
        }
        return flag;
    }
    private static class HashFuns{
        private int cap;
        private int seeds;

        public HashFuns(int cap,int seeds){
            this.cap = cap;
            this.seeds = seeds;
        }

        public int hash(String value){
            int result = 0;
            int len = value.length();
            for(int i=0;i<len;i++){
                result = seeds*result+value.charAt(i);
            }
            return (cap-1)&result;
        }
    }
}
