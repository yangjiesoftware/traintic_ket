package com.mangocity.util;

import java.text.SimpleDateFormat;

/**
 * 日期时间处理工具类
 * 
 * @author chenmubing
 * @since 1.0
 */
public class DateTimeUtils {

    /**
     * 将java.utils.Date类型日期转化为“yyyy-MM-dd”格式的String类型日期
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return String类型日期
     */
    public static String getDate(java.util.Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    /**
     * 返回字符型时间("HH:mm:ss")
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回字符型时间
     */
    public static String getTime(java.util.Date date) {
        return formatDate(date, "HH:mm:ss");
    }
    
    /**
     * 返回字符型时间("HH:mm")
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回字符型时间
     */
    public static String getTimeH(java.util.Date date) {
        return formatDate(date, "HH:mm");
    }

    /**
     * 返回字符型日期时间("yyyy-MM-dd HH:mm:ss")
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回字符型日期时间
     */
    public static String getDateTime(java.util.Date date) {
        return formatDate(date, "yyyy-MM-dd  HH:mm:ss");
    }

    /**
     * 将java.utils.Date类型日期转化为指定格式的String类型日期
     * 
     * @param date
     *            java.utils.Date类型日期
     * @param format
     *            指定的日期格式
     * @return String类型日期
     */
    public static String formatDate(java.util.Date date, String format) {
        String result = "";
        if (date != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                result = sdf.format(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将String类型日期转化为指定格式的java.utils.Date类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @param format
     *            格式
     * @return java.utils.Date类型日期
     */
    public static java.util.Date parseDate(String dateStr, String format) {
        java.util.Date date = null;
        if (dateStr.length() < format.length()) {
            format = format.substring(0, dateStr.length());
        }
        try {
            java.text.DateFormat df = new SimpleDateFormat(format);
            date = (java.util.Date) df.parse(dateStr);
        } catch (Exception e) {
            System.out.println("日期解析错误:" + dateStr);
        }
        return date;
    }

    /**
     * 将String类型日期转化为“yyyy-MM-dd”格式的java.utils.Date类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @return java.utils.Date类型日期
     */
    public static java.util.Date parseDate(String dateStr) {
        return parseDate(dateStr, "yyyy-MM-dd");
    }

    /**
     * 将java.sql.Date类型日期转化为java.utils.Date类型日期
     * 
     * @param date
     *            java.sql.Date类型日期
     * @return java.utils.Date类型日期
     */
    public static java.util.Date parseDate(java.sql.Date date) {
        return date;
    }

    /**
     * 将java.utils.Date类型日期转化为java.sql.Date类型日期
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return java.sql.Date类型日期
     */
    public static java.sql.Date parseSqlDate(java.util.Date date) {
        if (date != null)
            return new java.sql.Date(date.getTime());
        else
            return null;
    }

    /**
     * 将String类型日期转化为指定格式的java.sql.Date类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @param format
     *            指定格式
     * @return java.sql.Date类型日期
     */
    public static java.sql.Date parseSqlDate(String dateStr, String format) {
        java.util.Date date = parseDate(dateStr, format);
        return parseSqlDate(date);
    }

    /**
     * 将String类型日期转化为"yyyy-MM-dd"格式的java.sql.Date类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @return java.sql.Date类型日期
     */
    public static java.sql.Date parseSqlDate(String dateStr) {
        return parseSqlDate(dateStr, "yyyy-MM-dd");
    }

    /**
     * 将String类型日期转化为指定格式的java.sql.Timestamp类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @param format
     *            指定格式
     * @return java.sql.Timestamp类型日期
     */
    public static java.sql.Timestamp parseTimestamp(String dateStr, String format) {
        java.util.Date date = parseDate(dateStr, format);
        if (date != null) {
            long t = date.getTime();
            return new java.sql.Timestamp(t);
        } else
            return null;
    }

    /**
     * 将String类型日期转化为"yyyy-MM-dd HH:mm:ss"格式的java.sql.Timestamp类型日期
     * 
     * @param dateStr
     *            String类型日期
     * @return java.sql.Timestamp类型日期
     */
    public static java.sql.Timestamp parseTimestamp(String dateStr) {
        return parseTimestamp(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 返回年份
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回年份
     */
    public static int getYear(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.YEAR);
    }

    /**
     * 返回月份
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回月份
     */
    public static int getMonth(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MONTH) + 1;
    }

    /**
     * 返回日
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回日份
     */
    public static int getDay(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回小时
     */
    public static int getHour(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回分钟
     */
    public static int getMinute(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回秒钟
     */
    public static int getSecond(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.get(java.util.Calendar.SECOND);
    }

    /**
     * 返回毫秒
     * 
     * @param date
     *            java.utils.Date类型日期
     * @return 返回毫秒
     */
    public static long getMillis(java.util.Date date) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 日期相加
     * 
     * @param date
     *            java.utils.Date类型日期
     * @param day
     *            天数
     * @return 返回相加后的日期
     */
    public static java.util.Date addDate(java.util.Date date, int day) {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相减
     * 
     * @param date
     *            java.utils.Date类型日期
     * @param date1
     *            日期
     * @return 返回相减后的日期
     */
    public static int diffDate(java.util.Date date, java.util.Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

}
