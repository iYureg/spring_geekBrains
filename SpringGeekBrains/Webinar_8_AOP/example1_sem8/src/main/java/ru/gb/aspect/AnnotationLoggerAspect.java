package ru.gb.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AnnotationLoggerAspect {

    @AfterReturning(value = "@annotation(ToLog)", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("Method executed and returned: " + result);
    }
}
