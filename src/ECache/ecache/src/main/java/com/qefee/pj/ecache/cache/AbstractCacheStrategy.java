package com.qefee.pj.ecache.cache;

import com.qefee.pj.ecache.item.CacheItem;

/**
 * AbstractCacheStrategy.
 * <ul>
 * <li>date: 16/6/29</li>
 * </ul>
 *
 * @author tongjin
 */
public abstract class AbstractCacheStrategy implements ICacheStrategy {

    protected <T> CacheItem<T> newCacheItem(String key, T value, long during) {
        CacheItem<T> newItem = new CacheItem<>();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }
}
