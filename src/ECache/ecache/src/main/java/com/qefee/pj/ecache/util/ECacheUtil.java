package com.qefee.pj.ecache.util;

import android.content.Context;

import com.qefee.pj.ecache.ECache;

/**
 * ECacheUtil.
 * <ul>
 * <li>date: 16/7/1</li>
 * </ul>
 *
 * @author tongjin
 */
public class ECacheUtil {

    private static ECache cache;

    /**
     * get a default Context.
     * should call {@link #init} first
     * @return ECache
     */
    public static ECache getCache() {
        return cache;
    }

    /**
     * init a ECache.
     * @param context Context
     */
    public static void init(Context context) {
        cache = new ECache(context);
    }


}
