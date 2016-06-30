package com.qefee.pj.ecache;

import android.content.Context;

import com.qefee.pj.ecache.cache.AbstractCacheStrategy;
import com.qefee.pj.ecache.cache.ICacheStrategy;
import com.qefee.pj.ecache.cache.MemoryCacheStrategy;
import com.qefee.pj.ecache.cache.PreferencesCacheStrategy;
import com.qefee.pj.ecache.item.BooleanCacheItem;
import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.item.CharacterCacheItem;
import com.qefee.pj.ecache.item.DoubleCacheItem;
import com.qefee.pj.ecache.item.FloatCacheItem;
import com.qefee.pj.ecache.item.IntCacheItem;
import com.qefee.pj.ecache.item.JSONObjectCacheItem;
import com.qefee.pj.ecache.item.LongCacheItem;
import com.qefee.pj.ecache.item.StringCacheItem;

import org.json.JSONException;
import org.json.JSONObject;

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
            saveBooleanItemToMemory(key);
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
            saveIntItemToMemory(key);
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
            saveLongItemToMemory(key);
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
            saveCharacterItemToMemory(key);
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
            saveFloatItemToMemory(key);
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
            saveDoubleItemToMemory(key);
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
            saveStringItemToMemory(key);
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
    public JSONObject getJSONObject(String key) {
        return getJSONObject(key, null);
    }

    @Override
    public JSONObject getJSONObject(String key, JSONObject def) {
        if (memoryCache.has(key)) {
            return memoryCache.getJSONObject(key, def);
        } else if (preferencesCache.has(key)) {
            saveJSONObjectItemToMemory(key);
            return preferencesCache.getJSONObject(key, def);
        } else {
            return def;
        }
    }

    @Override
    public void set(String key, JSONObject value) {
        memoryCache.set(key, value);
        preferencesCache.set(key, value);
    }

    @Override
    public void set(String key, JSONObject value, long during) {
        memoryCache.set(key, value, during);
        preferencesCache.set(key, value, during);
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
    public CacheItem getCacheItem(String key) {
        if (memoryCache.has(key)) {
            return memoryCache.getCacheItem(key);
        } else if (preferencesCache.has(key)) {
            return preferencesCache.getCacheItem(key);
        } else {
            return null;
        }
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

    private void saveBooleanItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        BooleanCacheItem nItem = new BooleanCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(Boolean.parseBoolean(item.getValue().toString()));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveIntItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        IntCacheItem nItem = new IntCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(Integer.parseInt(item.getValue().toString()));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveLongItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        LongCacheItem nItem = new LongCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(Long.parseLong(item.getValue().toString()));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveFloatItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        FloatCacheItem nItem = new FloatCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(Float.parseFloat(item.getValue().toString()));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveDoubleItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        DoubleCacheItem nItem = new DoubleCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(Double.parseDouble(item.getValue().toString()));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveCharacterItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        CharacterCacheItem nItem = new CharacterCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(item.getValue().toString().charAt(0));
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveStringItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        StringCacheItem nItem = new StringCacheItem();
        nItem.setKey(item.getKey());
        nItem.setValue(item.getValue().toString());
        nItem.setCreateTime(item.getCreateTime());
        nItem.setUpdateTime(item.getUpdateTime());
        nItem.setDeleteTime(item.getDeleteTime());
        nItem.setCount(item.getCount());
        memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
    }

    private void saveJSONObjectItemToMemory(String key) {
        CacheItem item = preferencesCache.getCacheItem(key);
        JSONObjectCacheItem nItem = new JSONObjectCacheItem();
        nItem.setKey(item.getKey());
        try {
            nItem.setValue(new JSONObject(item.getValue().toString()));
            nItem.setCreateTime(item.getCreateTime());
            nItem.setUpdateTime(item.getUpdateTime());
            nItem.setDeleteTime(item.getDeleteTime());
            nItem.setCount(item.getCount());
            memoryCache.set(key, nItem.getValue(), nItem.getDeleteTime() - nItem.getUpdateTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
