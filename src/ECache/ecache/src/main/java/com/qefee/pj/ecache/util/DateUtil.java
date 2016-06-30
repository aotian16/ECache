package com.qefee.pj.ecache.util;

import com.qefee.pj.ecache.item.CacheItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtil.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public class DateUtil {

    public static final int TIME_UNIT_SECOND = 1000;
    public static final int TIME_UNIT_MINUTE = 60 * TIME_UNIT_SECOND;
    public static final int TIME_UNIT_HOUR = 60 * TIME_UNIT_MINUTE;
    public static final int TIME_UNIT_DAY = 24 * TIME_UNIT_HOUR;
    public static final int TIME_UNIT_MONTH = 30 * TIME_UNIT_DAY;
    public static final int TIME_UNIT_YEAR = 365 * TIME_UNIT_MONTH;

    public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public static String currentDateString() {
        return dateToString(new Date());
    }

    public static boolean isCacheItemAlive(CacheItem item) {
        return item.getDeleteTime() > System.currentTimeMillis();
    }
}
