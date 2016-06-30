package com.qefee.pj.ecache.cache;

import com.qefee.pj.ecache.item.BooleanCacheItem;
import com.qefee.pj.ecache.item.CharacterCacheItem;
import com.qefee.pj.ecache.item.DoubleCacheItem;
import com.qefee.pj.ecache.item.FloatCacheItem;
import com.qefee.pj.ecache.item.IntCacheItem;
import com.qefee.pj.ecache.item.JSONObjectCacheItem;
import com.qefee.pj.ecache.item.LongCacheItem;
import com.qefee.pj.ecache.item.StringCacheItem;

import org.json.JSONObject;

/**
 * AbstractCacheStrategy.
 * <ul>
 * <li>date: 16/6/29</li>
 * </ul>
 *
 * @author tongjin
 */
public abstract class AbstractCacheStrategy implements ICacheStrategy {


    protected IntCacheItem newIntCacheItem(String key, int value, long during) {
        IntCacheItem newItem = new IntCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected LongCacheItem newLongCacheItem(String key, long value, long during) {
        LongCacheItem newItem = new LongCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected FloatCacheItem newFloatCacheItem(String key, float value, long during) {
        FloatCacheItem newItem = new FloatCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected CharacterCacheItem newCharacterCacheItem(String key, char value, long during) {
        CharacterCacheItem newItem = new CharacterCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected DoubleCacheItem newDoubleCacheItem(String key, double value, long during) {
        DoubleCacheItem newItem = new DoubleCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected BooleanCacheItem newBooleanCacheItem(String key, boolean value, long during) {
        BooleanCacheItem newItem = new BooleanCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected StringCacheItem newStringCacheItem(String key, String value, long during) {
        StringCacheItem newItem = new StringCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }

    protected JSONObjectCacheItem newJSONObjectCacheItem(String key, JSONObject value, long during) {
        JSONObjectCacheItem newItem = new JSONObjectCacheItem();
        newItem.setKey(key);
        newItem.setValue(value);
        long currentTimeMillis = System.currentTimeMillis();
        newItem.setCreateTime(currentTimeMillis);
        newItem.setUpdateTime(currentTimeMillis);
        newItem.setDeleteTime(currentTimeMillis + during);
        return newItem;
    }
}
