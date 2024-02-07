package com.amitesh.junit5extension.executioncondition;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * This extension demonstrates how we can implement a custom {@link ExecutionCondition} which
 * determines if our test method should be invoked.
 */
public class DisableTestExecutionExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        System.out.println("evaluateExecutionCondition()");

        final Method testMethod = context.getRequiredTestMethod();
        final DisableTest disableTestAnnotation = testMethod.getDeclaredAnnotation(DisableTest.class);

        if (disableTestAnnotation == null) {
            throw new ExtensionConfigurationException(String.format(
                    "Couldn't find the @DisableTest annotation from the method: %s",
                    testMethod
            ));
        }

        return ConditionEvaluationResult.disabled("Disables test");
    }
}
