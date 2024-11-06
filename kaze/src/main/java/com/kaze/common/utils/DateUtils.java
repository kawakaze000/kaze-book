package com.kaze.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author ruoyi
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static final String YYYY = "yyyy";

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static final String[] PARSE_PATTERNS = {
        "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
        "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
        "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /* ************************************************************************************ */

    /**
     * Date -> String
     * yyyy-MM-dd HH:mm:ss
     */
    public static String date2String(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * String -> Date
     * @param pattern 字符串时间格式
     */
    public static Date string2Date(String date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        ParsePosition pos = new ParsePosition(0);
        return dateFormat.parse(date, pos);
    }

    /**
     * 获取指定天开始时间 00:00:00
     * String
     */
    public static String getDayStartTime(Date date) {
        return date2String(getStartTimeOfCurrentDay(date), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取指定天的开始时间 00:00:00
     * Date
     */
    public static Date getStartTimeOfCurrentDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间
     * String
     */
    public static String getDayNowTime() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当日结束时间 23:59:59
     * String
     */
    public static String getDayEndTime(Date date) {
        return date2String(getEndTimeOfCurrentDay(date), YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 获取当日结束时间 23:59:59
     * Date
     */
    public static Date getEndTimeOfCurrentDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        //将秒至0
        calendar.set(Calendar.SECOND, 59);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取当前时间前/后几天 00:00:00
     *
     * @param days 为正数，表示当前时间后几天; 为负数，表示当前时间前几天
     */
    public static Date getDayForInputNum(Date date, Integer days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int now = c.get(Calendar.DATE);
        c.set(Calendar.DATE, now + days);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当前周的周一 00:00:00
     */
    public static Date getCurrentWeekStartTime() {
        Calendar calendar = Calendar.getInstance();
        // 一周第一天为周日，所以此处日+1
        calendar.setWeekDate(calendar.getWeekYear(), calendar.get(Calendar.WEEK_OF_YEAR), 2);
        calendar.set(calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            0, 0, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前周的周日 23:59:59
     */
    public static Date getCurrentWeekEndTime() {
        Calendar calendar = Calendar.getInstance();
        // 一周第一天为周日，所以此处日+1
        calendar.setWeekDate(calendar.getWeekYear(), calendar.get(Calendar.WEEK_OF_YEAR) + 1, 1);
        calendar.set(calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            23, 59, 59);
        return calendar.getTime();
    }

    /**
     * 获取当前时间前/后几天
     *
     * @param days 为正数，表示当前时间后几天; 为负数，表示当前时间前几天
     */
    public static Date getDayTimeForInputNum(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE, days);
        date=calendar.getTime();
        return date;

    }

    /**
     * 获取当前时间前/后几天
     *
     * @param days 为正数，表示当前时间后几天; 为负数，表示当前时间前几天
     */
    public static Date getDayTimeForInput(Date date, Integer days, Integer hours) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int now = c.get(Calendar.DATE);
        c.set(Calendar.DATE, now + days);
        // 小时
        c.set(Calendar.HOUR_OF_DAY, hours);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }


    /**
     * 获取某月的第一天 00:00:00
     * Date
     * @param month 距当月几个月(为正: 下几月、为负: 前几月)
     *              当前为2023-2-15 16:00:00, month = -2, 返回2022-12-01 00:00:00
     *              当前为2023-2-15 16:00:00, month = 2, 返回2023-4-1 00:00:00
     */
    public static Date getMonthFirstDay(int month) {
        //获取当前日期
        Calendar cal_1 = Calendar.getInstance();
        cal_1.add(Calendar.MONTH, month);
        //设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        cal_1.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        cal_1.set(Calendar.MINUTE, 0);
        //将秒至0
        cal_1.set(Calendar.SECOND, 0);
        //将毫秒至0
        cal_1.set(Calendar.MILLISECOND, 0);
        return cal_1.getTime();
    }

    /**
     * 获取某月的最后一天 23:59:59
     * Date
     * @param month 距当月几个月(为正: 下几月、为负: 前几月)
     *              当前为2023-2-15 16:00:00, month = -2, 返回2022-12-31 23:59:59
     *              当前为2023-2-15 16:00:00, month = 0, 返回2023-2-28 23:59:59
     *              当前为2023-2-15 16:00:00, month = 2, 返回2023-4-30 23:59:59
     */
    public static Date getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, month);
        //将小时至0
        cal.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        cal.set(Calendar.MINUTE, 59);
        //将秒至0
        cal.set(Calendar.SECOND, 59);
        //将毫秒至0
        cal.set(Calendar.MILLISECOND, 999);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }

    /**
     * 获取下个月第一天 00:00:00
     * Date
     */
    public static Date getNextMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        //设置为指定日期
        c.setTime(date);
        //指定日期月份减去一
        c.add(Calendar.MONTH, 1);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        //获取最终的时间
        return c.getTime();
    }

    /**
     * 获取下个月最后一天 23:59:59
     * Date
     */
    public static Date getNextMonthLastDay(Date date) {
        Calendar c = Calendar.getInstance();
        //设置为指定日期
        c.setTime(date);
        //指定日期月份减去一
        c.add(Calendar.MONTH, 1);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        c.set(Calendar.MINUTE, 59);
        //将秒至0
        c.set(Calendar.SECOND, 59);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 999);
        //获取最终的时间
        return c.getTime();
    }

    /**
     * 获取上个月第一天 00:00:00
     * Date
     */
    public static Date getLastMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        //设置为指定日期
        c.setTime(date);
        //指定日期月份减去一
        c.add(Calendar.MONTH, -1);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        //获取最终的时间
        return c.getTime();
    }

    /**
     * 获取上个月最后一天 23:59:59
     * Date
     */
    public static Date getLastMonthLastDay(Date date) {
        Calendar c = Calendar.getInstance();
        //设置为指定日期
        c.setTime(date);
        //指定日期月份减去一
        c.add(Calendar.MONTH, -1);
        //指定日期月份减去一后的 最大天数
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        c.set(Calendar.MINUTE, 59);
        //将秒至0
        c.set(Calendar.SECOND, 59);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 999);
        //获取最终的时间
        return c.getTime();
    }

    /**
     * 获取当年的第一天 00:00:00
     * Date
     */
    public static Date getCurrentFirstOfYear(){
        Calendar currCal = Calendar.getInstance();
        currCal.set(Calendar.MONTH, currCal.getActualMinimum(Calendar.MONTH));
        //指定日期月份减去一后的 最大天数
        currCal.set(Calendar.DATE, 1);
        //将小时至0
        currCal.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        currCal.set(Calendar.MINUTE, 0);
        //将秒至0
        currCal.set(Calendar.SECOND, 0);
        //将毫秒至0
        currCal.set(Calendar.MILLISECOND, 0);
        return currCal.getTime();
    }

    /**
     * 获取当年的最后一天 23:59:59
     * Date
     */
    public static Date getCurrentLastOfYear(){
        Calendar currCal = Calendar.getInstance();
        currCal.set(Calendar.MONTH, currCal.getActualMaximum(Calendar.MONTH));
        //指定日期月份减去一后的 最大天数
        currCal.set(Calendar.DATE, currCal.getActualMaximum(Calendar.DATE));
        //将小时至0
        currCal.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        currCal.set(Calendar.MINUTE, 59);
        //将秒至0
        currCal.set(Calendar.SECOND, 59);
        //将毫秒至0
        currCal.set(Calendar.MILLISECOND, 999);
        return currCal.getTime();
    }

    /**
     * 获取某年第一天日期 00:00:00
     * Date
     * @param year 距当月几个月(为正: 下几月、为负: 前几月)
     *              当前为2023-2-15 16:00:00, year = -2, 返回2021-01-01 00:00:00
     *              当前为2023-2-15 16:00:00, year = 0, 返回2023-01-01 00:00:00
     *              当前为2023-2-15 16:00:00, year = 2, 返回2025-01-01 00:00:00
     */
    public static Date getFirstOfYear(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        //指定日期月份减去一后的 最大天数
        calendar.set(Calendar.DATE, 1);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取某年最后一天日期 23:59:59
     * Date
     * @param year 距当月几个月(为正: 下几月、为负: 前几月)
     *              当前为2023-2-15 16:00:00, year = -2, 返回2021-12-31 23:59:59
     *              当前为2023-2-15 16:00:00, year = 0, 返回2023-12-31 23:59:59
     *              当前为2023-2-15 16:00:00, year = 2, 返回2025-12-31 23:59:59
     */
    public static Date getLastOfYear(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        //指定日期月份减去一后的 最大天数
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        //将秒至0
        calendar.set(Calendar.SECOND, 59);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 返回日期的日期, 即yyyy-MM-dd中的dd
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的月份, 即yyyy-MM-dd中的MM
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日期的年, 即yyyy-MM-dd中的yyyy
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /* ************************************************************************************ */

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     * String -> Date
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), PARSE_PATTERNS);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算相差天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 增加 LocalDateTime ==> Date
     */
    public static Date toDate(LocalDateTime temporalAccessor) {
        ZonedDateTime zdt = temporalAccessor.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    /**
     * 增加 LocalDate ==> Date
     */
    public static Date toDate(LocalDate temporalAccessor) {
        LocalDateTime localDateTime = LocalDateTime.of(temporalAccessor, LocalTime.of(0, 0, 0));
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }
}
