package com.qefee.pj.ecache.cache;

import com.qefee.pj.ecache.item.CacheItem;

import org.json.JSONObject;

/**
 * ICacheStrategy.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public interface ICacheStrategy {
    // boolean

    /**
     * get boolean if exists or false.
     *
     * @param key key
     * @return value
     */
    boolean getBoolean(String key);

    /**
     * get boolean if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    boolean getBoolean(String key, boolean def);

    /**
     * set boolean.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, boolean value);

    /**
     * st boolean.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, boolean value, long during);
    // int

    /**
     * get int if exists or 0.
     *
     * @param key key
     * @return value
     */
    int getInt(String key);

    /**
     * get int if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    int getInt(String key, int def);

    /**
     * set int.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, int value);

    /**
     * set int.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, int value, long during);
    // long

    /**
     * get long if exists or 0.
     *
     * @param key key
     * @return value
     */
    long getLong(String key);

    /**
     * get long if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    long getLong(String key, long def);

    /**
     * set long.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, long value);

    /**
     * set long.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, long value, long during);

    // char

    /**
     * get long if exists or '0'.
     *
     * @param key key
     * @return value
     */
    char getChar(String key);

    /**
     * get char if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    char getChar(String key, char def);

    /**
     * set char.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, char value);

    /**
     * set char.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, char value, long during);

    // float

    /**
     * get float if exists or 0.
     *
     * @param key key
     * @return value
     */
    float getFloat(String key);

    /**
     * get float if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    float getFloat(String key, float def);

    /**
     * set float.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, float value);

    /**
     * set float.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, float value, long during);

    // double

    /**
     * get double if exists or 0.
     *
     * @param key key
     * @return value
     */
    double getDouble(String key);

    /**
     * get double if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    double getDouble(String key, double def);

    /**
     * set double.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, double value);

    /**
     * set double.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, double value, long during);

    // string

    /**
     * get string if exists or "".
     *
     * @param key key
     * @return value
     */
    String getString(String key);

    /**
     * get string if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    String getString(String key, String def);

    /**
     * set string.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * set string.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, String value, long during);

    // JSONObject

    /**
     * get JSONObject if exists or null.
     *
     * @param key key
     * @return value
     */
    JSONObject getJSONObject(String key);

    /**
     * get JSONObject if exists or def.
     *
     * @param key key
     * @param def def
     * @return value
     */
    JSONObject getJSONObject(String key, JSONObject def);

    /**
     * set JSONObject.
     *
     * @param key   key
     * @param value value
     */
    void set(String key, JSONObject value);

    /**
     * set JSONObject.
     *
     * @param key    key
     * @param value  value
     * @param during during
     */
    void set(String key, JSONObject value, long during);

    /**
     * has item
     * @param key key
     * @return true if exists or false
     */
    boolean has(String key);

    /**
     * delete item.
     * @param key key
     * @return deleted item
     */
    CacheItem del(String key);

    /**
     * get origin cache item.
     * @param key key
     * @return item
     */
    CacheItem getCacheItem(String key);

    /**
     * clear dead items.
     */
    void clearDeadItems();

    /**
     * get size.
     * @param level level
     * @return size
     */
    int size(int level);
}
