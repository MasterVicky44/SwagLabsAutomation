package com.swagLabs.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class RetryTransformer implements IAnnotationTransformer {


    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor constructor, Method testMethod) {
        System.out.println("RetryTransformer called for: " + testMethod.getName());
        if (annotation.getRetryAnalyzerClass() == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}
