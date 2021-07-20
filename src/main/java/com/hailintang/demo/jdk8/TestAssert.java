package com.hailintang.demo.jdk8;

import com.google.common.collect.Lists;

import java.util.List;

public class TestAssert{
     public static void main(String[] args){
         String name = "abner chai";
//         String name = null;
         assert (name!=null):"变量name为空null";
         System.out.println(name);
         List<Long> productIds = Lists.newArrayList(1L,2L);
         System.out.println(productIds);
     }
}