package com.devious.ban.singleton;

public class ThreadSafeSingletonImproved {
    private static volatile ThreadSafeSingletonImproved instance;

    private static final Object MUTEX = new Object();

    private ThreadSafeSingletonImproved() {
        // Private constructor to prevent direct instantiation.
    }

    public static ThreadSafeSingletonImproved getInstance() {
        ThreadSafeSingletonImproved singleton = instance;
        if (singleton == null) {
            synchronized (MUTEX) {
                singleton = instance;

                if (singleton == null) {
                    instance = singleton = new ThreadSafeSingletonImproved();
                }
            }
        }

        return singleton;
    }
}
