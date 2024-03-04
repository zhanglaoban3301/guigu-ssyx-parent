package com.atguigu.ssyx.common.store;

import java.util.HashMap;
import java.util.Map;

public class JavaStore {
    // 定义一个静态的Map变量存储数据
    public static Map<String, Object> sharedMap = new HashMap<>();

    // 提供静态方法来操作和访问共享数据
    public static void putData(String key, Object value) {
        sharedMap.put(key, value);
    }

    public static Object getData(String key) {
        return sharedMap.get(key);
    }
}
