package com.google.monitoring.runtime.instrumentation;

import java.util.HashMap;
import java.util.Map;
public class TimeHolder {
    private static Map<String, Long> timeCache = new HashMap<>();

    public native void clearTree2();

    public static void start(String method) {
        TimeHolder ai = new  TimeHolder();
        ai.clearTree2();

        System.out.println("Method start: " + method);
        timeCache.put(method, System.currentTimeMillis());
    }

    public static long cost(String method) {
        System.out.println("Method end: " + method);
        return System.currentTimeMillis() - timeCache.get(method);
    }

}
