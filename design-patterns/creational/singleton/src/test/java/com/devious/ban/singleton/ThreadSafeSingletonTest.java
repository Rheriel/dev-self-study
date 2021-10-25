package com.devious.ban.singleton;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ThreadSafeSingletonTest {

    @RepeatedTest(500)
    void shouldCreateOnlyOneSingletonInstanceInAMultiThreadedEnvironment() throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        final Set<ThreadSafeSingleton> shouldOnlyHaveOneElement = new HashSet<>();

        for (int i = 0; i < 100000; i++) {
            executor.execute(() -> {
                final ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
                shouldOnlyHaveOneElement.add(singleton);
            });
        }

        assertEquals(1, shouldOnlyHaveOneElement.size());

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
