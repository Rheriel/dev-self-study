package com.devious.ban.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SimpleSingletonTest {

    @Test
    void shouldReturnAlwaysTheSameInstance() {
        final SimpleSingleton singleton = SimpleSingleton.getInstance();

        for (int i = 0; i < 1000; i++) {
            assertEquals(singleton, SimpleSingleton.getInstance());
        }
    }
}
