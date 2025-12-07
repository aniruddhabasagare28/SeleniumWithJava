package test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Simple TestNG retry analyzer.
 * Default retries = 1. Override by passing -Dtest.retry.count=2 (for example) to the JVM.
 */
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private final int maxRetryCount;

    public RetryAnalyzer() {
        int configured = 2; // default to 1 retry
        String val = System.getProperty("test.retry.count");
        if (val != null) {
            try {
                configured = Integer.parseInt(val);
            } catch (NumberFormatException ignored) {
                // keep default
            }
        }
        this.maxRetryCount = configured;
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.printf("[RetryAnalyzer] Retrying %s: attempt %d/%d%n", result.getName(), retryCount, maxRetryCount);
            return true;
        }
        return false;
    }
}

