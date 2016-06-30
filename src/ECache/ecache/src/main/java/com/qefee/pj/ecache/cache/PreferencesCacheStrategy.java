package com.qefee.pj.ecache.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.qefee.pj.ecache.item.BooleanCacheItem;
import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.item.CharacterCacheItem;
import com.qefee.pj.ecache.item.DoubleCacheItem;
import com.qefee.pj.ecache.item.FloatCacheItem;
import com.qefee.pj.ecache.item.IntCacheItem;
import com.qefee.pj.ecache.item.JSONObjectCacheItem;
import com.qefee.pj.ecache.item.LongCacheItem;
import com.qefee.pj.ecache.item.StringCacheItem;
import com.qefee.pj.ecache.util.DateUtil;
import com.qefee.pj.ecache.util.GsonUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

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
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            BooleanCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, BooleanCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, boolean value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, boolean value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            BooleanCacheItem newItem = newBooleanCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            BooleanCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, BooleanCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            IntCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, IntCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, int value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, int value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            IntCacheItem newItem = newIntCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            IntCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, IntCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            LongCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, LongCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, long value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, long value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            LongCacheItem newItem = newLongCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            LongCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, LongCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public char getChar(String key) {
        return getChar(key, '0');
    }

    @Override
    public char getChar(String key, char def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            CharacterCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, CharacterCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, char value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, char value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            CharacterCacheItem newItem = newCharacterCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            CharacterCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, CharacterCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    @Override
    public float getFloat(String key, float def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            FloatCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, FloatCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, float value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, float value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            FloatCacheItem newItem = newFloatCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            FloatCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, FloatCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public double getDouble(String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(String key, double def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            DoubleCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, DoubleCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, double value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, double value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            DoubleCacheItem newItem = newDoubleCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            DoubleCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, DoubleCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public String getString(String key) {
        return getString(key, "");
    }

    @Override
    public String getString(String key, String def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            StringCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, StringCacheItem.class);

            if (DateUtil.isCacheItemAlive(item)) {
                int count = item.getCount();
                count++;
                item.setCount(count);

                saveItem(key, item);
                return item.getValue();
            } else {
                return def;
            }
        }
    }

    @Override
    public void set(String key, String value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, String value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            StringCacheItem newItem = newStringCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            StringCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, StringCacheItem.class);
            item.setValue(value);
            long time = System.currentTimeMillis();
            item.setUpdateTime(time);
            item.setDeleteTime(time + during);

            saveItem(key, item);
        }
    }

    @Override
    public JSONObject getJSONObject(String key) {
        return getJSONObject(key, null);
    }

    @Override
    public JSONObject getJSONObject(String key, JSONObject def) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            return def;
        } else {
            StringCacheItem strItem = GsonUtil.getGson().fromJson(itemJsonStr, StringCacheItem.class);
            String value = strItem.getValue();
            JSONObject jsonObj;
            try {
                jsonObj = new JSONObject(value);
                JSONObjectCacheItem item = newJSONObjectCacheItem(key, jsonObj, DateUtil.TIME_UNIT_MINUTE);

                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);

                    saveItem(key, item);
                    return item.getValue();
                } else {
                    return def;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return def;
            }

        }
    }

    @Override
    public void set(String key, JSONObject value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, JSONObject value, long during) {
        String itemJsonStr = sharedPreferences.getString(key, "");

        if (TextUtils.isEmpty(itemJsonStr)) {
            JSONObjectCacheItem newItem = newJSONObjectCacheItem(key, value, during);
            saveItem(key, newItem);
        } else {
            StringCacheItem strItem = GsonUtil.getGson().fromJson(itemJsonStr, StringCacheItem.class);

            String itemValue = strItem.getValue();
            JSONObject jsonObj;
            try {
                jsonObj = new JSONObject(itemValue);
                JSONObjectCacheItem item = newJSONObjectCacheItem(key, jsonObj, DateUtil.TIME_UNIT_MINUTE);
                item.setValue(value);
                long time = System.currentTimeMillis();
                item.setUpdateTime(time);
                item.setDeleteTime(time + during);

                saveItem(key, item);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
    public CacheItem getCacheItem(String key) {
        String string = sharedPreferences.getString(key, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        } else {
            return GsonUtil.getGson().fromJson(string, StringCacheItem.class);
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
                StringCacheItem item = GsonUtil.getGson().fromJson(itemJsonStr, StringCacheItem.class);
                if (!DateUtil.isCacheItemAlive(item)) {
                    edit.remove(key);
                }
            }
        }
        edit.apply();
    }

    @Override
    public int size(int level) {
        return sharedPreferences.getAll().size();
    }

    private void saveItem(String key, CacheItem item) {
        String jsonStr = GsonUtil.getGson().toJson(item);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, jsonStr);
        edit.apply();
    }
}
