package com.hailintang.demo.jdk8.struct;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    int m;
    public int inc(){
        return m+1;
    }

    public static void main(String[] args) {
        List<Integer> cityIds = new ArrayList<>();
        cityIds.add(1);
        cityIds.add(2);
        cityIds.add(3);
        System.out.println(cityIds);
        String join = StringUtils.join(cityIds.toArray(), ",");
        System.out.println(join);
    }
}
