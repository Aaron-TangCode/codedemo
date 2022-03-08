package com.hailintang.demo.jdk8;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hailin.tang
 * @date 2020-03-25 17:03
 * @function
 */
public class Boy {


    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
    if(SEQ.intValue()>9990){
    SEQ.getAndSet(1000);
    }
    return dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
    }



    @Test
    public void testChooseTime() {
        Long today = DateUtils.strToDate("2021-11-17", DateUtils.YYYY_MM_DD).getTime();

        Long nextDay = DateUtils.addDay(new Date(today), 1).getTime();

        List<Long> timeList = new ArrayList<>();

        for (long i = today; i < nextDay; ) {
            long curTime = today;
            timeList.add(curTime);
            i = DateUtils.addMinute(today, 30).getTime();
        }

        System.out.println(timeList);
    }

    @Test
    public void testDouble2BigDecimal() {
        //普通
        System.out.println(93.74 + 23.43);
        //double
        BigDecimal b1 = new BigDecimal(93.74 + 23.43);
        System.out.println("normal:" + b1);
        //double
        BigDecimal b2 = new BigDecimal("93.74");
        BigDecimal b3 = new BigDecimal("23.43");
        BigDecimal b23 = b2.add(b3);
        System.out.println("double-构造方法:" + b23);
        //字符串
        BigDecimal b4 = new BigDecimal(93.74 + "");
        BigDecimal b5 = new BigDecimal(23.43 + "");
        BigDecimal b45 = b4.add(b5);
        System.out.println("String-构造方法:" + b45);
        //四舍五入
        BigDecimal b6 = new BigDecimal(93.74 + "");
        BigDecimal b7 = new BigDecimal(23.41 + "");
        BigDecimal b8 = new BigDecimal(23.40 + "");
        BigDecimal b67 = b6.add(b7).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b68 = b6.add(b8).setScale(1, RoundingMode.HALF_UP);
        System.out.println("四舍五入-1:" + b67);
        System.out.println("四舍五入-2:" + b68);
        //四舍六入
        BigDecimal b9 = new BigDecimal(93.74 + "");
        BigDecimal b10 = new BigDecimal(23.43 + "");
        BigDecimal b45_3 = b4.add(b5).setScale(1, RoundingMode.HALF_DOWN);
        System.out.println("四舍六入:" + b45_3);


        BigDecimal b99 = new BigDecimal(21.58);
        BigDecimal b100 = b99.divide(BigDecimal.valueOf(100));

        BigDecimal dispatchFee = BigDecimal.valueOf(139).multiply(b100).setScale(2, RoundingMode.HALF_UP);
        System.out.println(dispatchFee);

        BigDecimal test1 = BigDecimal.valueOf(0).add(BigDecimal.valueOf(0));
        System.out.println("test1:"+test1);

//        BigDecimal ratio = new BigDecimal(7.65+"").divide(BigDecimal.valueOf(100));
//        System.out.println("ratio:"+ratio);
        BigDecimal price = new BigDecimal(115).multiply(new BigDecimal(7.65+"").divide(BigDecimal.valueOf(100))).setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println("price:"+price);

        String str = "2019-11-20 12:02:00.0";
        System.out.println(str.substring(12));

        System.out.println(System.nanoTime());
    }

    public static double sub(Double value1, Double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2).doubleValue();
    }

    @Test
    public void testOrderIdGenerater() {

        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0, 8000).parallel().forEach(i -> {
            orderNos.add(generateOrderNo());
        });

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("生成订单数：" + orderNos.size());
        System.out.println("过滤重复后订单数：" + filterOrderNos.size());
        System.out.println("重复订单数：" + (orderNos.size() - filterOrderNos.size()));
    }

    @Test
    public void testIsNumber(){
        boolean number1 = NumberUtil.isNumber("123");
        System.out.println(number1);
        boolean number2 = NumberUtil.isNumber("12a");
        System.out.println(number2);
    }

    @Test
    public void testHutool(){
        String orderIds = "1,2,3";
        String[] split = orderIds.split(",");
        ArrayList<String> strings = ListUtil.toList(split);
        System.out.println(strings);
    }
}
