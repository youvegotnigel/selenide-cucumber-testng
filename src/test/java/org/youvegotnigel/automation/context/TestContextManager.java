package org.youvegotnigel.automation.context;

public class TestContextManager {

    // ThreadLocal ensures each thread gets its own ScenarioContext
    private static final ThreadLocal<ApiTestContext> context = new ThreadLocal<>();

    // Initialize context for each scenario
    public static void initializeContext() {
        context.set(new ApiTestContext());
    }

    // Get context for current thread
    public static ApiTestContext getContext() {
        return context.get();
    }

    // Clean up context
    public static void cleanupContext() {
        context.remove();
    }
}
