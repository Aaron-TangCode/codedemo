package com.hailintang.demo.jdk8;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {

    public static String FORMAT = "yyyyMMddHHmmssms";
    public static String YYMMDD_FORMAT = "yyyyMMdd";
    public static String HHmm_FORMAT = "HH:mm";
    public static String HHmmss_FORMAT = "HH:mm:ss";

    public static String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String FORMAT_NO_SECONDES = "yyyy/MM/dd HH:mm";
    public static String YYYYMMDD="yyyyMMdd";
    public static String FORMAT_DEFAULT_MIN = "yyyyMMddHHmmss";
    public static String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_DEFAULT_CH = "yyyy年MM月dd日 HH时mm分ss秒";
    public static String FORMAT_DEFAULT_YMD = "yyyy-MM-dd";
    public static String FORMAT_DEFAULT_YMDHM ="yyyy-MM-dd HH:mm";
    public static String FORMAT_DEFAULT_ME = "yyyy-MM";
    public static String FORMAT_DEFAULT_M = "yyyy年MM月";
    private static String USER_VISIT_INVALIDTIME = "1970-01-01 00:00:00";
    public static String REFUND_WEEK_DAY="yyyy-MM-dd (EEEE) HH:mm:ss";
    public static String M_DD_HHMMSS = "M-dd HH:mm:ss";
//    private static Date invalidTime;

    public static boolean isInvalidTime4Visit(Date date){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date invalidTime = dateFormat.parse(USER_VISIT_INVALIDTIME);
            if (invalidTime.compareTo(date) == 0) {
                return true;
            }
            return false;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 增加30分钟
     */
    public static Date addMinute(long date ,int addMinute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(date));

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, addMinute);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static String getYymmddStr(Date date) {
        SimpleDateFormat YYMMDD_Sdf = new SimpleDateFormat(YYMMDD_FORMAT);
        return YYMMDD_Sdf.format(date);
    }

    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(FORMAT);
        return format.format(date);
    }


    public static String formatToYYYYMMDD(String formatStr, Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }


    public static String formatToHHmm(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(HHmm_FORMAT);
        return format.format(date);
    }

    public static String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    public static String getDateDetailStr(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    public static String getDateNOSPLIT(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
    public static String getDate(String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(new Date());
    }

    public static Date getDate(Date date,int day,int month,int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MONTH,month);
        calendar.add(Calendar.YEAR,year);
        date = calendar.getTime();
        return date;
    }

//    public static Date strToDate(String formatStr,String dateStr) throws ParseException {
//        DateFormat format = new SimpleDateFormat(formatStr);
//        return format.parse(dateStr);
//    }

    public static String dateToStr(String formatStr,Date date)  {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

    public static String dateToStrLocal(String formatStr,Date date)  {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr,Locale.CHINA);
        return format.format(date);
    }

    public static String dateToStrGMT(String formatStr,Date date)  {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(date);
    }

    /**
     * 获取精确到秒的时间戳
     *
     * @return
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.parseInt(timestamp.substring(0, length - 3));
        } else {
            return 0;
        }
    }
    
    
    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     * @param timestampString 时间戳 如："1473048265";
     *
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String timeStamp2Date(String timestampString) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(timestamp));
    }

    /**
     * 返回day天前时间
     * @param date
     * @return
     */
    public static Date getOneMonthBefore(Date date,int day){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();

    }

    /**
     * 获取时间当天的的起始时间
     */
    public static Date getDayStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }
    /**
     * 当前天的中午12点
     */
    public static Date getDayNoon() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }
    /**
     * 当前天的起始时间
     */
    public static Date getDayBeforeStart(Date date,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH,day);
        return calendar.getTime();
    }

    /**
     * 当前天的结束时间
     */
    public static Date getDayEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.addDay(date, 1));

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 当前月的开始时间
     */
    public static Date getMonthStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }
    /**
     * 当前月的开始时间
     */
    public static Date getNextMonthStart(int mon,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MONTH,mon);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 在日期上添加天的日期.
     *
     * @param date the date
     * @param num the num
     * @return the date
     */
    public static Date addDay(Date date, int num) {
        return add(date, Calendar.DAY_OF_MONTH, num);
    }

    public static Date add(Date date, int field, int num) {
        Calendar cal = getCalendar(date);
        cal.add(field, num);
        return cal.getTime();
    }

    /**
     * 设置周一为当前周的第一天
     *
     * @param date the date
     * @return the calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        return cal;
    }

    /**
     * 字符串转换为日期类型
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date strToDate(String dateStr, String format) {
        if (null == dateStr || StringUtils.isEmpty(dateStr)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            // e.printStackTrace();
        }
        return null;
    }
    public static int getAge(Date birthday){
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }
    public void getCalendarTest(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
//        calendar.setTime(DateUtils.strToDate("2019-04-01 18:30:00","yyyy-MM-dd HH:mm:ss"));
        System.out.println("现在时间是："+new Date());
        String year=String.valueOf(calendar.get(Calendar.YEAR));
        String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String week=String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)-1);
        String weeks=String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
        if(calendar.get(Calendar.DAY_OF_WEEK)-1==0){
            weeks = String.valueOf(Integer.parseInt(weeks) - 1);
            week = String.valueOf(Integer.parseInt(week) + 7);
        }
        System.out.println("现在时间是："+year+"年"+month+"月"+day+"日，星期"+week+" 第"+weeks+"周");
    }

    public static Date deadline30(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 30);
        return calendar.getTime();
    }

    // 返回某个日期后几天的日期
    public static Date getNextDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + i);
        return cal.getTime();
    }

    public static Date getMonthStart(long timeStamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeStamp));

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date getMonthEnd(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeStamp));

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }
    // 返回某个日期后前几天的日期
    public static Date getBeforeDay(Date date, int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - i);
        return cal.getTime();
    }

    /**
     * 根据日期计算出 年 月 期
     * @param date 日期
     * @return
     */
    public static Map<String,String> getTimeByDate(Date date){
        Map<String,String> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        String[] split = dateNowStr.split("-");
        if(split.length==3){
            //年 //月 //日 //期(阶段)
            String year = split[0];
            String month = split[1];
            String day = split[2];
            String phase = "2";
            if(Integer.parseInt(day)>0 && Integer.parseInt(day)<16){
                phase = "1";
            }
            map.put("year",year);
            map.put("month",month);
            map.put("phase",phase);
        }
        return map;
    }
    public static void main(String[] args) {
//        Date milestone = DateUtils.strToDate("2020-03-10 20:00:00","yyyy-MM-dd HH:mm:ss");
//
//        System.out.println(milestone);
        String today = DateUtils.dateToStr(DateUtils.YYYYMMDD, new Date());
        System.out.println(today);
        //查询昨天

        String yesterday =DateUtils.dateToStr(DateUtils.YYYYMMDD, DateUtils.getBeforeDay(new Date(), 20));
        System.out.println(yesterday);
        //查询上周的今天
        String lastWeekday = DateUtils.dateToStr(DateUtils.YYYYMMDD, DateUtils.getBeforeDay(new Date(), 21));
        System.out.println(lastWeekday);

        System.out.println(1 - (1.2 / 1));
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(2);
        String format = numberFormat.format(1 - (1.2 / 1));
        System.out.println(format);

        System.out.println("==="+dateToStr(HHmmss_FORMAT, new Date(Long.parseLong("45000000"))));

    }
    public static BigDecimal doubleToBigdecimal(Double price){
        if(price == null){
            return BigDecimal.ZERO;
        }
        return  new BigDecimal(price+"");
    }
    public static double bigdecimalToDouble(BigDecimal price){
        if(price == null){
            return 0.0;
        }
        return  price.doubleValue();
    }

    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();
    }
    public static Date formateDate(long date) throws Exception{
        String formateStr = formatToYYYYMMDD(YYYY_MM_DD,new Date(date));
        return strToDate(formateStr,YYYY_MM_DD);
    }
}
