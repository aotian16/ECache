package com.qefee.pj.ecache.cache;

import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.util.DateUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * MemoryCacheStrategy.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public class MemoryCacheStrategy extends AbstractCacheStrategy {

    Map<String, CacheItem> cacheMap = new HashMap<>();

    @Override
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        return getItem(key, def, boolean.class);
    }

    @Override
    public void set(String key, boolean value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, boolean value, long during) {
        setItem(key, value, during, boolean.class);
    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int def) {
        return getItem(key, def, int.class);
    }

    @Override
    public void set(String key, int value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, int value, long during) {
        setItem(key, value, during, int.class);
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long def) {
        return getItem(key, def, long.class);
    }

    @Override
    public void set(String key, long value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, long value, long during) {
        setItem(key, value, during, long.class);
    }

    @Override
    public char getChar(String key) {
        return getChar(key, '0');
    }

    @Override
    public char getChar(String key, char def) {
        return getItem(key, def, char.class);
    }

    @Override
    public void set(String key, char value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, char value, long during) {
        setItem(key, value, during, char.class);
    }

    @Override
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    @Override
    public float getFloat(String key, float def) {
        return getItem(key, def, float.class);
    }

    @Override
    public void set(String key, float value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, float value, long during) {
        setItem(key, value, during, float.class);
    }

    @Override
    public double getDouble(String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(String key, double def) {
        return getItem(key, def, double.class);
    }

    @Override
    public void set(String key, double value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, double value, long during) {
        setItem(key, value, during, double.class);
    }

    @Override
    public String getString(String key) {
        return getString(key, "");
    }

    @Override
    public String getString(String key, String def) {
        return getItem(key, def, String.class);
    }

    @Override
    public void set(String key, String value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, String value, long during) {
        setItem(key, value, during, String.class);
    }

    @Override
    public <E> E getJSONObject(String key, Class<E> eClass) {
        return getJSONObject(key, null);
    }

    @Override
    public <E> E getJSONObject(String key, E def, Class<E> eClass) {
        return getItem(key, def, eClass);
    }

    @Override
    public <E> void set(String key, E value, Class<E> eClass) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE, eClass);
    }

    @Override
    public <E> void set(String key, E value, long during, Class<E> eClass) {
        setItem(key, value, during, eClass);
    }

    @Override
    public boolean has(String key) {
        return cacheMap.containsKey(key);
    }

    @Override
    public CacheItem del(String key) {
        return cacheMap.remove(key);
    }

    @Override
    public <T> CacheItem<T> getCacheItem(String key, Class<CacheItem<T>> tClass) {
        CacheItem cacheItem = cacheMap.get(key);
        if (cacheItem.getClass().isAssignableFrom(tClass)) {
            return (CacheItem<T>)cacheItem;
        } else {
            return null;
        }
    }

    @Override
    public <T> void setCacheItem(String key, T value, long during, Class<CacheItem<T>> tClass) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (tClass.isAssignableFrom(item.getClass())) {
                CacheItem<T> oItem = (CacheItem<T>)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newCacheItem(key, value, during));
        }
    }

    @Override
    public void clearDeadItems() {
        Iterator<Map.Entry<String, CacheItem>> iterator = cacheMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, CacheItem> next = iterator.next();

            CacheItem item = next.getValue();

            if (item != null) {
                if (!DateUtil.isCacheItemAlive(item)) {
                    iterator.remove();
                }
            } else {
                iterator.remove();
            }
        }
    }

    @Override
    public int size(int level) {
        return cacheMap.size();
    }

    public <T> T getItem(String key, T def, Class<T> tClass) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (tClass.isAssignableFrom(item.getValue().getClass())) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return (T) item.getValue();
                } else {
                    return def;
                }
            } else {
                return def;
            }
        } else {
            return def;
        }
    }

    public <T> void setItem(String key, T value, long during, Class<T> tClass) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (tClass.isAssignableFrom(item.getValue().getClass())) {
                CacheItem<T> oItem = (CacheItem<T>)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newCacheItem(key, value, during));
        }
    }
}
