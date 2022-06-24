package com.hailintang.demo.hutool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.hailintang.demo.jdk8.DateUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestDateUtil {

    public static void main(String[] args) {
        Date dayStart = getMonthStart();
        long time = dayStart.getTime();
        System.out.println(time);
        DateTime dateTime = DateUtil.beginOfMonth(new Date());
        long time1 = dateTime.getTime();
        System.out.println(time1);
    }

    @Test
    public void getHour(){
        int i = DateUtil.thisHour(true);
        System.out.println(i);
        long s = DateUtils.getDayEnd(new Date()).getTime()+60*24*60*60*1000L;
        long time = DateUtils.getDayEnd(new Date()).getTime();
        System.out.println(s);
        System.out.println(time);
    }

    @Test
    public void testBigDecimal(){
//        BigDecimal totalNum = new BigDecimal(11);
//        BigDecimal bigDecimal = totalNum.multiply(new BigDecimal(0.3)).setScale(0, BigDecimal.ROUND_UP);
//        System.out.println(bigDecimal);
        double sub = sub(1D, 0.01);
        System.out.println(sub);
        BigDecimal bigDecimal = new BigDecimal(sub+"");
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println(bigDecimal1);
    }
    @Test
    public void testString() throws UnsupportedEncodingException {
        String msgStr = new String("eyJjbGllbnRJZCI6MzMwNTY1MjUwMzEzMDk5Njg1NiwiY29kZSI6MTAwMDAxLCJkYXRhIjp7InBheU9yZGVySWQiOjM1NTIwOTMxMzUyNTU0MzgxMDUsInVuaXF1ZUNvZGUiOiIzNTUyMDkzMTQ1OTkyODU1NzM0IiwidG90YWxGZWUiOjEuMCwiaXNHcm91cFBheSI6ZmFsc2UsIm9yZGVyRmxhZyI6MywicGF5Vm91Y2hlcnNJZCI6MzU1MjA5MzE0NTk5Mjg1NTU3Nywic3RhdGUiOjIwMywiY3VzZXJJZCI6ODI2NTA1MDA3NDE2NjMsImNoYW5uZWxJZCI6IjgyIn19".getBytes(),"UTF-8");
        System.out.println(msgStr);
    }

    public static double sub(Double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1 == null ? 0 : d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    @Test
    public void testDemo(){
        String str = "35\n" +
                "14\n" +
                "33\n" +
                "35\n" +
                "17\n" +
                "2\n" +
                "20\n" +
                "30\n" +
                "32\n" +
                "16\n" +
                "30\n" +
                "12\n" +
                "11\n" +
                "10\n" +
                "19\n" +
                "15\n" +
                "9\n" +
                "8\n" +
                "9\n" +
                "4\n" +
                "15\n" +
                "8\n" +
                "5\n" +
                "5\n" +
                "2\n" +
                "18\n" +
                "9\n" +
                "6\n" +
                "17\n" +
                "5\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "2\n" +
                "4\n" +
                "1\n" +
                "10\n" +
                "19\n" +
                "3\n" +
                "1\n" +
                "11\n" +
                "29\n" +
                "4\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "8\n" +
                "4\n" +
                "1\n" +
                "6\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "5\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "1\n" +
                "9\n" +
                "6\n" +
                "4\n" +
                "3\n" +
                "4\n" +
                "7\n" +
                "4\n" +
                "1\n" +
                "4\n" +
                "11\n" +
                "4\n" +
                "1\n" +
                "1\n" +
                "8\n" +
                "3\n" +
                "6\n" +
                "1\n" +
                "2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "6\n" +
                "3\n" +
                "3\n" +
                "5\n" +
                "2\n" +
                "5\n" +
                "2\n" +
                "2\n" +
                "5\n" +
                "1\n" +
                "3\n" +
                "3\n" +
                "2\n" +
                "6\n" +
                "8\n" +
                "4\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "3\n" +
                "3\n" +
                "3\n" +
                "4\n" +
                "2\n" +
                "1\n" +
                "1\n" +
                "2\n" +
                "2\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "3\n" +
                "3\n" +
                "2\n" +
                "1";
        String[] split = str.split("\n");
        int sum = 0;
        for(int i=0;i<split.length;i++){
            String num = split[i];
            sum = sum + Integer.parseInt(num);
        }
        System.out.println(sum);
    }
    @Test
    public void testTransformation(){
        String cityIds = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "16\n" +
                "18\n" +
                "37\n" +
                "79\n" +
                "93\n" +
                "102\n" +
                "122\n" +
                "135\n" +
                "147\n" +
                "158\n" +
                "172\n" +
                "188\n" +
                "202\n" +
                "222\n" +
                "228\n" +
                "241\n" +
                "265\n" +
                "276\n" +
                "291\n" +
                "297\n" +
                "304\n" +
                "319\n" +
                "330\n" +
                "342\n" +
                "355\n" +
                "362\n" +
                "375\n" +
                "385\n" +
                "394\n" +
                "403\n" +
                "408\n" +
                "413\n" +
                "414\n" +
                "424\n" +
                "463\n" +
                "471\n" +
                "483\n" +
                "497\n" +
                "505\n" +
                "518\n" +
                "523\n" +
                "531\n" +
                "541\n" +
                "556\n" +
                "572\n" +
                "592\n" +
                "606\n" +
                "613\n" +
                "623\n" +
                "629\n" +
                "637\n" +
                "645\n" +
                "652\n" +
                "669\n" +
                "693\n" +
                "696\n" +
                "700\n" +
                "710\n" +
                "722\n" +
                "740\n" +
                "771\n" +
                "772\n" +
                "783\n" +
                "791\n" +
                "801\n" +
                "811\n" +
                "821\n" +
                "837\n" +
                "845\n" +
                "858\n" +
                "872\n" +
                "891\n" +
                "910\n" +
                "914\n" +
                "944\n" +
                "952\n" +
                "961\n" +
                "968\n" +
                "977\n" +
                "984\n" +
                "993\n" +
                "1016\n" +
                "1029\n" +
                "1039\n" +
                "1057\n" +
                "1078\n" +
                "1086\n" +
                "1096\n" +
                "2015\n" +
                "2037\n" +
                "2045\n" +
                "2047\n" +
                "2049\n" +
                "2052\n" +
                "2053\n" +
                "2054\n" +
                "2055\n" +
                "2247\n" +
                "2325\n" +
                "2342\n" +
                "2350\n" +
                "2354\n" +
                "2363\n" +
                "2372\n" +
                "2373\n" +
                "2378\n" +
                "2422\n" +
                "2429\n" +
                "3177\n" +
                "3266\n" +
                "3470\n" +
                "5853\n" +
                "6700\n" +
                "6964\n" +
                "7133\n" +
                "7624\n" +
                "10116\n" +
                "12221\n" +
                "13895";
        String num = "3\n" +
                "1\n" +
                "2\n" +
                "1";

        String tempCityIds = "37\n" +
                "102\n" +
                "147\n" +
                "2055";



        String[] splitcityIds = cityIds.split("\n");//全部数据

        String[] tempsplitcityIds = tempCityIds.split("\n");//部分数据
        String[] nums = num.split("\n");//部分数据
        List<Integer> cityList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        Set<String> targetSet = new HashSet<>(Arrays.asList(tempsplitcityIds));

        //遍历splitcityIds.length次
        //如果
        int k = 0;
        for(int i=0;i<splitcityIds.length;i++){

            String splitcityId = splitcityIds[i];
            cityList.add(Integer.valueOf(splitcityId));
            if(targetSet.contains(splitcityId)){
                String num1 = nums[k];
                k = k +1;
                numList.add(Integer.valueOf(num1));
            }else{
                numList.add(0);
            }
        }
        System.out.println(cityList);
        System.out.println(numList);
    }

    @Test
    public void testLRU() throws InterruptedException, ExecutionException {
//        Cache<String,String> cache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();
//
//        cache.put("1","213");
//        Thread.sleep(1000);
//        System.out.println(cache.getIfPresent("1"));
//       Thread.sleep(2000);
//        System.out.println(cache.getIfPresent("1"));

        //定义Cache，并定义未命中时的载入方法
        LoadingCache<Integer, Integer> cache = CacheBuilder.newBuilder().build(new CacheLoader<Integer, Integer>() {
            @Override
            public Integer load(Integer key) throws Exception {
                return key + 1;
            }
        });
        System.out.println(cache.get(1)); //第一个get：第一次访问key，使用载入方法载入
        System.out.println( cache.get(1)); //第二个get：第二次访问，在缓存中得到value);


    }

    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date getMonthStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }
}

