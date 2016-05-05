package com.leonhart.aopplayground.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import static java.lang.System.nanoTime;

@Aspect
public class Measure {
    private long start;

    @Pointcut("execution(@com.leonhart.aopplayground.api.Measure * *(..))")
    public void beanAnnotatedWithMeasure() {}

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Before("publicMethod() && beanAnnotatedWithMeasure()")
    public void beforeTraceMethods(JoinPoint joinPoint) {
        start = nanoTime();
    }

    @AfterReturning("publicMethod() && beanAnnotatedWithMeasure()")
    public void afterTraceMethods(JoinPoint joinPoint) {
        long stop = System.nanoTime();
        System.out.println("Time in: " + joinPoint + " = " + (stop - start));
    }
}
