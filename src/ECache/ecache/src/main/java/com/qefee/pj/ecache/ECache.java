package com.qefee.pj.ecache;

import android.support.annotation.NonNull;

import com.qefee.pj.ecache.cache.Cache;
import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.util.DateUtil;

import io.realm.RealmConfiguration;

/**
 * ECache.
 * <ul>
 * <li>date: 16/6/29</li>
 * </ul>
 *
 * @author tongjin
 */
public class ECache {

    private static Cache cache;

    private static Cache getCache() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }

    public static void init(RealmConfiguration configuration) {
        cache = new Cache(configuration);
    }

    public static String get(@NonNull final String key) {
        CacheItem cacheItem = getCache().retrieve(key);

        if (cacheItem == null) {
            return null;
        } else {
            if (DateUtil.isCacheItemAlive(cacheItem)) {
                return cacheItem.getValue();
            } else {
                getCache().delete(key);
                return "";
            }
        }

    }

    public static void set(@NonNull final String key, @NonNull final String value, final long during) {
        CacheItem cacheItem = getCache().retrieve(key);

        if (cacheItem == null) {
            getCache().create(key, value, during);
        } else {
            getCache().update(key, value, during);
        }
    }

    public static void delete(@NonNull final String key) {
        getCache().delete(key);
    }

    public static void deleteExpiredItems() {
        getCache().deleteExpiredItems();
    }

    public static void deleteAll() {
        getCache().deleteAll();
    }

}
