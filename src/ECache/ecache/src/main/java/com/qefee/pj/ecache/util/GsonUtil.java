package com.qefee.pj.ecache.util;

import com.google.gson.Gson;

/**
 * GsonUtil.
 * <ul>
 * <li>date: 16/6/29</li>
 * </ul>
 *
 * @author tongjin
 */
public class GsonUtil {
    public static Gson getGson() {
        return gson;
    }

    private static final Gson gson = new Gson();
}
