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
ECache.set(key, value, DateUtil.TIME_UNIT_MINUTE * 3);
ECache.delete(key);
```



## Install

#### 1 By jitpack.io

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath "io.realm:realm-gradle-plugin:2.2.1" // install realm plugin
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
```groovy
    dependencies {
            compile 'com.github.aotian16:ECache:v3.0.0'
    }
```

then 

#### 2 Or Download this project and import as a module

```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath "io.realm:realm-gradle-plugin:2.2.1" // install realm plugin
    }
}
```



## Version history

| No.  | Version | Detail         |
| ---- | ------- | -------------- |
| 1    | 1.0.0   | first version  |
| 2    | 2.0.0   | refactor       |
| 3    | 3.0.0   | based on realm |

## [LICENSE](https://github.com/aotian16/ECache/blob/master/LICENSE)

MIT