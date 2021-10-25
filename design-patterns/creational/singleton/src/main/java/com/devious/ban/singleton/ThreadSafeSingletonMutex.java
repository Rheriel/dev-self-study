package com.devious.ban.singleton;

public class ThreadSafeSingletonMutex {
    private static volatile ThreadSafeSingletonMutex instance;

    private static Object mutex = new Object();

    private ThreadSafeSingletonMutex() {
        // Empty constructor to prevent instantiation outside this class.
    }

    public static ThreadSafeSingletonMutex getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                instance = new ThreadSafeSingletonMutex();
            }
        }

        return instance;
    }
}
