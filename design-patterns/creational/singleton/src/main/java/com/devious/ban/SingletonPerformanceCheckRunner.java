package com.devious.ban;

import com.devious.ban.singleton.SimpleSingleton;
import com.devious.ban.singleton.ThreadSafeSingleton;
import com.devious.ban.singleton.ThreadSafeSingletonImproved;
import com.devious.ban.singleton.ThreadSafeSingletonMutex;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SingletonPerformanceCheckRunner {
    private static final int NUMBER_OF_THREADS = 10;

    private static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) throws InterruptedException {
        checkSimpleSingletonPerformance();
        stopWatch.reset();
        checkThreadSafeSingletonPerformance();
        stopWatch.reset();
        checkThreadSafeSingletonMutexPerformance();
        stopWatch.reset();
        checkThreadSafeSingletonImprovedPerformance();
        stopWatch.reset();
    }

    private static void checkSimpleSingletonPerformance() {
        log.info("Simple Singleton - Performance Test on getInstance()...");

        stopWatch.start();
        final SimpleSingleton singleton = SimpleSingleton.getInstance();
        stopWatch.stop();

        log.info("Simple Singleton - getInstance() took: {} nano seconds.", stopWatch.getTime(TimeUnit.NANOSECONDS));
    }

    private static void checkThreadSafeSingletonPerformance() throws InterruptedException {
        log.info("Thread Safe Singleton - Performance Test on getInstance()...");
        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        stopWatch.start();
        executorService.execute(() -> {
            final ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        });
        stopWatch.stop();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        log.info("Thread Safe Singleton - getInstance() took: {} nano seconds.", stopWatch.getTime(TimeUnit.NANOSECONDS) / NUMBER_OF_THREADS);
    }

    private static void checkThreadSafeSingletonMutexPerformance() throws InterruptedException {
        log.info("Thread Safe Singleton Mutex - Performance Test on getInstance()...");

        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        stopWatch.start();
        executorService.execute(() -> {
            final ThreadSafeSingletonMutex singleton = ThreadSafeSingletonMutex.getInstance();
        });
        stopWatch.stop();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        log.info("Thread Safe Singleton Mutex - getInstance() took: {} nano seconds.", stopWatch.getTime(TimeUnit.NANOSECONDS) / NUMBER_OF_THREADS);
    }

    private static void checkThreadSafeSingletonImprovedPerformance() throws InterruptedException {
        log.info("Thread Safe Singleton Improved - Performance Test on getInstance()...");

        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        stopWatch.start();
        executorService.execute(() -> {
            final ThreadSafeSingletonImproved singleton = ThreadSafeSingletonImproved.getInstance();
        });
        stopWatch.stop();
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        log.info("Thread Safe Singleton Improved - getInstance() took: {} nano seconds.", stopWatch.getTime(TimeUnit.NANOSECONDS) / NUMBER_OF_THREADS);
    }
}
