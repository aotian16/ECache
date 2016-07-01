# ECache
An easy to use android cache based on `SharedPreferences` and `Gson`.

There are two level cache in ECache.

1. Memory
2. SharedPreferences

# Support type

| No.  | Type       | Support |
| :--: | ---------- | :-----: |
|  1   | boolean    |    √    |
|  2   | int        |    √    |
|  3   | long       |    √    |
|  4   | char       |    √    |
|  5   | float      |    √    |
|  6   | double     |    √    |
|  7   | String     |    √    |
|  8   | JSONObject |    √    |

# Usage

```java
		final ECache cache = new ECache(this);
        String key = "test";
        int value = 666;
        int during = DateUtil.TIME_UNIT_HOUR;

        cache.set(key, value, during);

        int def = 0;
        int i = cache.getInt(key, def);
```

# Todo

support more type

# Install

1. Download this project
2. Import this project as a module
3. Add dependence to ECache

# Version history

| No.  | Version | Detail        |
| ---- | ------- | ------------- |
| 1    | 1.0.0   | first version |

# [LICENSE](https://github.com/aotian16/ECache/blob/master/LICENSE)

MIT