package com.qefee.pj.ecache;

import android.content.Context;

import com.qefee.pj.ecache.cache.AbstractCacheStrategy;
import com.qefee.pj.ecache.cache.ICacheStrategy;
import com.qefee.pj.ecache.cache.MemoryCacheStrategy;
import com.qefee.pj.ecache.cache.PreferencesCacheStrategy;
import com.qefee.pj.ecache.item.CacheItem;

/**
 * ECache.
 * <ul>
 * <li>date: 16/6/29</li>
 * </ul>
 *
 * @author tongjin
 */
public class ECache extends AbstractCacheStrategy {

    public static final String NAME = "ecache";

    ICacheStrategy memoryCache;
    ICacheStrategy preferencesCache;

    public ECache(Context context) {
        this(context, NAME);
    }

    public ECache(Context context, String name) {
        memoryCache = new MemoryCacheStrategy();
        preferencesCache = new PreferencesCacheStrategy(context, name);
    }

    @Override
    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        if (memoryCache.has(key)) {
            return memoryCache.getBoolean(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Boolean> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getBoolean(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, boolean value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, boolean value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);

    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int def) {
        if (memoryCache.has(key)) {
            return memoryCache.getInt(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Integer> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getInt(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, int value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, int value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long def) {
        if (memoryCache.has(key)) {
            return memoryCache.getLong(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Long> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getLong(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, long value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, long value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public char getChar(String key) {
        return getChar(key, '0');
    }

    @Override
    public char getChar(String key, char def) {
        if (memoryCache.has(key)) {
            return memoryCache.getChar(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Character> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getChar(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, char value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, char value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    @Override
    public float getFloat(String key, float def) {
        if (memoryCache.has(key)) {
            return memoryCache.getFloat(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Float> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getFloat(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, float value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, float value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public double getDouble(String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(String key, double def) {
        if (memoryCache.has(key)) {
            return memoryCache.getDouble(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<Double> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getDouble(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, double value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, double value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public String getString(String key) {
        return getString(key, "");
    }

    @Override
    public String getString(String key, String def) {
        if (memoryCache.has(key)) {
            return memoryCache.getString(key, def);
        } else if (preferencesCache.has(key)) {
            CacheItem<String> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getString(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, String value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, String value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
    }

    @Override
    public <E> E getJSONObject(String key, Class<E> eClass) {
        return getJSONObject(key, null, eClass);
    }

    @Override
    public <E> E getJSONObject(String key, E def, Class<E> eClass) {
        if (memoryCache.has(key)) {
            return memoryCache.getJSONObject(key, def, eClass);
        } else if (preferencesCache.has(key)) {
            CacheItem<E> t = new CacheItem<>();
            saveItemToMemory(key, t.getGenericType(0));
            return preferencesCache.getJSONObject(key, def, eClass);
        } else {
            return def;
        }
    }

    @Override
    public <E> void set(String key, E value, Class<E> eClass) {
        memoryCache.set(key, value, eClass);
        preferencesCache.set(key, value, eClass);
    }

    @Override
    public <E> void set(String key, E value, long during, Class<E> eClass) {
        memoryCache.set(key, value, during, eClass);
        preferencesCache.set(key, value, during, eClass);
    }

    @Override
    public boolean has(String key) {
        return memoryCache.has(key) || preferencesCache.has(key);
    }

    @Override
    public CacheItem del(String key) {
        CacheItem del = memoryCache.del(key);
        preferencesCache.del(key);
        return del;
    }

    @Override
    public <T> CacheItem<T> getCacheItem(String key, Class<CacheItem<T>> tClass) {
        if (memoryCache.has(key)) {
            return memoryCache.getCacheItem(key, tClass);
        } else if (preferencesCache.has(key)) {
            return preferencesCache.getCacheItem(key, tClass);
        } else {
            return null;
        }
    }

    @Override
    public <T> void setCacheItem(String key, T value, long during, Class<CacheItem<T>> tClass) {
        memoryCache.setCacheItem(key, value, during, tClass);
        preferencesCache.setCacheItem(key, value, during, tClass);
    }

    @Override
    public void clearDeadItems() {
        memoryCache.clearDeadItems();
        preferencesCache.clearDeadItems();
    }

    @Override
    public int size(int level) {
        int size;
        switch (level) {
            case 0:
                size = memoryCache.size(level);
                break;
            case 1:
                size = preferencesCache.size(level);
                break;
            default:
                size = 0;
                break;
        }
        return size;
    }

    private <T> void saveItemToMemory(String key, Class<CacheItem<T>> tClass) {
        CacheItem<T> item = preferencesCache.getCacheItem(key, tClass);
        CacheItem<T> nItem = new CacheItem<>();
        nItem.setKey(item.getKey());
        nItem.setValue(item.getValue());
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem, nItem.getDeleteTime() - nItem.getUpdateTime(), tClass);
    }
}
