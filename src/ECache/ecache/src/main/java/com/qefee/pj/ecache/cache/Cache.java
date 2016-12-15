package com.qefee.pj.ecache.cache;

import android.support.annotation.NonNull;
import android.util.Log;

import com.qefee.pj.ecache.item.CacheItem;
import com.qefee.pj.ecache.util.DateUtil;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Cache.
 * <ul>
 * <li>date: 2016/12/14</li>
 * </ul>
 *
 * @author tongjin
 */

public class Cache {

    /**
     * log tag for Cache
     */
    private static final String TAG = "Cache";
    private static final String DEFAULT_NAME = "ECache";

    private Realm realm;

    public Cache() {
        realm = Realm.getInstance(new RealmConfiguration.Builder().name(DEFAULT_NAME).build());
    }

    public Cache(RealmConfiguration configuration) {
        realm = Realm.getInstance(configuration);
    }

    public void create(@NonNull final String key, @NonNull final String value, final long during) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CacheItem cacheItem = realm.createObject(CacheItem.class, key);

                cacheItem.setValue(value);
                Date date = new Date();
                long time = date.getTime();
                cacheItem.setCreateTime(time);
                cacheItem.setUpdateTime(time);
                cacheItem.setDeleteTime(time + during);
                cacheItem.setCount(0);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "onSuccess: create cache item to realm success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: create cache item to realm fail", error);
            }
        });
    }

    public CacheItem retrieve(@NonNull final String key) {
        return realm.where(CacheItem.class).equalTo("key", key).findFirst();
    }

    public void update(@NonNull final String key, @NonNull final String value, final long during) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CacheItem cacheItem = realm.where(CacheItem.class).equalTo("key", key).findFirst();

                cacheItem.setValue(value);
                Date date = new Date();
                long time = date.getTime();
//                cacheItem.setCreateTime(time);
                cacheItem.setUpdateTime(time);
                cacheItem.setDeleteTime(time + during);
                cacheItem.setCount(0);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "onSuccess: update cache item in realm success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: update cache item in realm fail", error);
            }
        });
    }

    public void delete(@NonNull final String key) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CacheItem cacheItem = realm.where(CacheItem.class).equalTo("key", key).findFirst();

                if (cacheItem == null) {
                    Log.i(TAG, "execute: cache item is null");
                } else {
                    cacheItem.deleteFromRealm();
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "onSuccess: delete cache item from realm success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: delete cache item from realm fail", error);
            }
        });
    }

    public void deleteExpiredItems() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CacheItem> cacheItems = realm.where(CacheItem.class).findAll();

                for (CacheItem i :
                        cacheItems) {
                    if (!DateUtil.isCacheItemAlive(i)) {
                        i.deleteFromRealm();

                        Log.i(TAG, String.format("execute: delete cache item (key = %s) from realm", i.getKey()));
                    }
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.i(TAG, "onSuccess: delete expired cache item from realm success");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e(TAG, "onError: delete expired cache item from realm fail", error);
            }
        });
    }

    public void deleteAll() {
        realm.deleteAll();
    }
}
