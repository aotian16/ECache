package com.qefee.pj.ecache.item;

import java.util.Locale;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * CacheItem.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public class CacheItem extends RealmObject {
    /**
     * item key.
     */
    @PrimaryKey
    private String key;
    /**
     * item value.
     */
    private String value;
    /**
     * create time.
     */
    private long createTime;
    /**
     * update time.
     */
    private long updateTime;
    /**
     * delete time.
     */
    private long deleteTime;
    /**
     * getInt count.
     */
    private int count;

    public Class getGenericType(int index) {
        return getClass();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int countOfGet) {
        this.count = countOfGet;
    }

    @Override
    public String toString() {
        return String.format(Locale.CHINA, "{'key':'%s', 'value':'%s', 'createTime':'%d', 'updateTime':'%d', 'deleteTime':'%d', 'count':'%d'}", getKey(), getValue(), getCreateTime(), getUpdateTime(), getDeleteTime(), getCount());
    }
}
