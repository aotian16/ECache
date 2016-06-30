package com.qefee.pj.ecache.item;

/**
 * CacheItem.
 * <ul>
 * <li>date: 16/6/28</li>
 * </ul>
 *
 * @author tongjin
 */
public class CacheItem<T> {
    /**
     * item key.
     */
    private String key;
    /**
     * item value.
     */
    private T value;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
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
}
