package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import retry.RetryAnalyzer;

public class RetryListener implements IAnnotationTransformer
{
public void transform(ITestAnnotation annotation, Class testClass, Constructor constructor, Method method)
{
	annotation.setRetryAnalyzer(RetryAnalyzer.class);
}
}

/*
Test Start
    ↓
Fail
    ↓
Extent Report
    ↓
Screenshot
    ↓
Retry Analyzer
    ↓
Retry
    ↓
Pass
 */
