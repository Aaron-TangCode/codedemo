package com.hailintang.demo.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MoneyUtil {
    /**
     * 分转元，转换为bigDecimal在toString
     * @return
     */
    public static double changeF2Y(int price){
        String s = BigDecimal.valueOf(price).divide(new BigDecimal(100)).toString();
        return Double.parseDouble(s);
    }
    /**
     * 元转分，确保price保留两位有效数字
     * @return
     */
    public static int changeY2F(double price) {
        DecimalFormat df = new DecimalFormat("#.00");
        price = Double.parseDouble(df.format(price));
        return (int)(price * 100);
    }

    public static void main(String[] args) {
        System.out.println(changeF2Y(111));

        System.out.println(BigDecimal.valueOf(MoneyUtil.changeF2Y((int) 150)));
    }
}