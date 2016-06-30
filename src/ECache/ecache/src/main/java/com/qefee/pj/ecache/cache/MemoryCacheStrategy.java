package com.qefee.pj.ecache.cache;

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

import org.json.JSONObject;

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
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof BooleanCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((BooleanCacheItem)item).getValue();
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

    @Override
    public void set(String key, boolean value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, boolean value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof BooleanCacheItem) {
                BooleanCacheItem oItem = (BooleanCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newBooleanCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newBooleanCacheItem(key, value, during));
        }
    }

    @Override
    public int getInt(String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(String key, int def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof IntCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((IntCacheItem)item).getValue();
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

    @Override
    public void set(String key, int value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, int value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof IntCacheItem) {
                IntCacheItem oItem = (IntCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newIntCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newIntCacheItem(key, value, during));
        }
    }

    @Override
    public long getLong(String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(String key, long def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof LongCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((LongCacheItem)item).getValue();
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

    @Override
    public void set(String key, long value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, long value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof LongCacheItem) {
                LongCacheItem oItem = (LongCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newLongCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newLongCacheItem(key, value, during));
        }
    }

    @Override
    public char getChar(String key) {
        return getChar(key, '0');
    }

    @Override
    public char getChar(String key, char def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof CharacterCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((CharacterCacheItem)item).getValue();
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

    @Override
    public void set(String key, char value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, char value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof CharacterCacheItem) {
                CharacterCacheItem oItem = (CharacterCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newCharacterCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newCharacterCacheItem(key, value, during));
        }
    }

    @Override
    public float getFloat(String key) {
        return getFloat(key, 0);
    }

    @Override
    public float getFloat(String key, float def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof FloatCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((FloatCacheItem)item).getValue();
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

    @Override
    public void set(String key, float value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, float value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof FloatCacheItem) {
                FloatCacheItem oItem = (FloatCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newFloatCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newFloatCacheItem(key, value, during));
        }
    }

    @Override
    public double getDouble(String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(String key, double def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof DoubleCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((DoubleCacheItem)item).getValue();
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

    @Override
    public void set(String key, double value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, double value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof DoubleCacheItem) {
                DoubleCacheItem oItem = (DoubleCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newDoubleCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newDoubleCacheItem(key, value, during));
        }
    }

    @Override
    public String getString(String key) {
        return getString(key, "");
    }

    @Override
    public String getString(String key, String def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof StringCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((StringCacheItem)item).getValue();
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

    @Override
    public void set(String key, String value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, String value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof StringCacheItem) {
                StringCacheItem oItem = (StringCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newStringCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newStringCacheItem(key, value, during));
        }
    }

    @Override
    public JSONObject getJSONObject(String key) {
        return getJSONObject(key, null);
    }

    @Override
    public JSONObject getJSONObject(String key, JSONObject def) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof JSONObjectCacheItem) {
                if (DateUtil.isCacheItemAlive(item)) {
                    int count = item.getCount();
                    count++;
                    item.setCount(count);
                    return ((JSONObjectCacheItem)item).getValue();
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

    @Override
    public void set(String key, JSONObject value) {
        set(key, value, DateUtil.TIME_UNIT_MINUTE);
    }

    @Override
    public void set(String key, JSONObject value, long during) {
        CacheItem item = cacheMap.get(key);

        if (item != null) {
            if (item instanceof JSONObjectCacheItem) {
                JSONObjectCacheItem oItem = (JSONObjectCacheItem)item;

                long updateTime = System.currentTimeMillis();
                oItem.setUpdateTime(updateTime);
                oItem.setDeleteTime(updateTime + during);
                oItem.setValue(value);
            } else {
                del(key);
                cacheMap.put(key, newJSONObjectCacheItem(key, value, during));
            }
        } else {
            cacheMap.put(key, newJSONObjectCacheItem(key, value, during));
        }
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
    public CacheItem getCacheItem(String key) {
        return cacheMap.get(key);
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
}
