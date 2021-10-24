package com.devious.ban.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class SimpleSingletonTest {

    @Test
    void shouldReturnAlwaysTheSameInstance() {
        final SimpleSingleton singleton = SimpleSingleton.getInstance();

        for (int i = 0; i < 1000; i++) {
            assertEquals(singleton, SimpleSingleton.getInstance());
        }
    }

    @Test
    void shouldFailThreadSafetyCheck() throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        final Set<SimpleSingleton> shouldOnlyHaveOneElement = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            executor.execute(() -> {
                final SimpleSingleton singleton = SimpleSingleton.getInstance();
                shouldOnlyHaveOneElement.add(singleton);
            });
        }

        assertNotEquals(1, shouldOnlyHaveOneElement.size());

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
