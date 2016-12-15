## ECache
An easy to use android cache based on `realm`.

## Support type

| No.  | Type   | Support |
| :--: | ------ | :-----: |
|  1   | string |    √    |



## Usage

### 1. init realm in your application or first activity

```java
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().migration(new RealmMigration() {
            @Override
            public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                Log.i(TAG, String.format("migrate: oldVersion = %d, newVersion = %d", oldVersion, newVersion));
            }
        }).schemaVersion(BuildConfig.VERSION_CODE).name("test").build();
        Realm realm = Realm.getInstance(realmConfiguration);
        ECache.init(realm);
```

### 2. get, set cache

```java
ECache.get(key);
ECache.set(key, value, during);
ECache.delete(key);
```



## Install

#### 1 By jitpack.io

```groovy
    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
```groovy
    dependencies {
            compile 'com.github.aotian16:ECache:v3.0.0'
    }
```

#### 2 Or Download this project and import as a module

## Version history

| No.  | Version | Detail         |
| ---- | ------- | -------------- |
| 1    | 1.0.0   | first version  |
| 2    | 2.0.0   | refactor       |
| 3    | 3.0.0   | based on realm |

## [LICENSE](https://github.com/aotian16/ECache/blob/master/LICENSE)

MIT