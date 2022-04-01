package com.hailintang.demo.hutool;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.Arrays;

public class TestStrUtil {
    @Test
    public void test1(){
        String orderIds = "123,124,125";
        String orderId = "124";

        String[] split = StrUtil.split(orderIds, ",");

    }
}
