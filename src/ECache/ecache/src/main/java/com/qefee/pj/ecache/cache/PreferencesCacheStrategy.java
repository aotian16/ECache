package com.qefee.pj.ecache.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.util.DateUtil;
import com.qefee.pj.ecache.util.GsonUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * PreferencesCacheStrategy.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public class PreferencesCacheStrategy extends AbstractCacheStrategy {

    public static final String NAME = "ecache";
    public static final String KEY_PREFIX = NAME + "_";

    SharedPreferences sharedPreferences;

    public PreferencesCacheStrategy(Context context) {
        this(context, NAME);
    }

    public PreferencesCacheStrategy(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

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
        return getJSONObject(key, null, eClass);
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
        return sharedPreferences.contains(key);
    }

    @Override
    public CacheItem del(String key) {
        return null;
    }

    @Override
    public <T> CacheItem<T> getCacheItem(String key, Class<CacheItem<T>> tClass) {
        String string = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        } else {
            return GsonUtil.getGson().fromJson(string, tClass);
        }
    }

    @Override
    public <T> void setCacheItem(String key, T value, long during, Class<CacheItem<T>> tClass) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            CacheItem newItem = newCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            CacheItem<T> item = GsonUtil.getGson().fromJson(itemJsonStr, tClass);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public void clearDeadItems() {
        Map<String, ?> all = sharedPreferences.getAll();

        Iterator<? extends Map.Entry<String, ?>> iterator = all.entrySet().iterator();

        SharedPreferences.Editor edit = sharedPreferences.edit();
        while (iterator.hasNext()) {
            Map.Entry<String, ?> next = iterator.next();

            String key = next.getKey();
            String itemJsonStr = next.getValue().toString();

            if (TextUtils.isEmpty(itemJsonStr)) {
                edit.remove(key);
            } else {
                CacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, CacheItem.class);
                if (!DateUtil.isCacheItemAlive(item)) {
                    edit.remove(key);
                }
            }
        }
        edit.apply();
    }

    @Override
    public int size(int level) {
        Map<String, ?> all = sharedPreferences.getAll();
        Set<String> keySet = all.keySet();

        int count = 0;
        for (String key:keySet) {
            if (key.startsWith(KEY_PREFIX)) {
                count++;
            }
        }

        return count;
    }

    private void saveItem(String key, CacheItem item) {
        String jsonStr = GsonUtil.getGson().toJson(item);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, jsonStr);
        edit.apply();
    }

    private <T> T getItem(String key, T def, Class<T> tClass) {
        String realKey = KEY_PREFIX + key;
        String itemJsonStr = sharedPreferences.getString(realKey, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            CacheItem<T> item = GsonUtil.getGson().fromJson(itemJsonStr, tClass.getGenericSuperclass());

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(realKey, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    public <T> void setItem(String key, T value, long during, Class<T> tClass) {
        String realKey = KEY_PREFIX + key;
        String itemJsonStr = sharedPreferences.getString(realKey, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            CacheItem newItem = newCacheItem(realKey, value, during);
            saveItem(realKey, newItem);
        } else {
            CacheItem<T> temp = new CacheItem<>();
            CacheItem<T> item = GsonUtil.getGson().fromJson(itemJsonStr, temp.getClass());
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(realKey, item);
        }
    }
}
