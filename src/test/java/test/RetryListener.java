package test;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Global TestNG annotation transformer that assigns RetryAnalyzer to all @Test methods
 * when not already specified. This avoids adding retryAnalyzer on every @Test.
 */
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Set the retry analyzer unconditionally. This avoids calling a getter that may not exist
        // on some TestNG versions and ensures all tests use the RetryAnalyzer by default.
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
