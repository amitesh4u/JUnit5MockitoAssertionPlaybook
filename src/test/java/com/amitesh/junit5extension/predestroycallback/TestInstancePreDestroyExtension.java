package com.amitesh.junit5extension.predestroycallback;

import com.amitesh.junit5extension.postprocessor.Logger;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;

/**
 * This extension demonstrates how we can implement an extension which processes the test object
 * before it's destroyed.
 */
public class TestInstancePreDestroyExtension implements TestInstancePreDestroyCallback {

    @Override
    public void preDestroyTestInstance(ExtensionContext context) throws Exception {
        System.out.println("preDestroyTestInstance()");

        Object testInstance = context.getTestInstance().orElse(null);
        if (testInstance != null) {
            Field loggerField = Arrays.stream(testInstance.getClass().getDeclaredFields())
                    .filter(f -> f.getType().equals(Logger.class))
                    .findFirst()
                    .orElse(null);

            if (loggerField != null) {
                loggerField.setAccessible(true);
                loggerField.set(testInstance, null);
            }
        }
    }
}
