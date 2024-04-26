package ru.gb.homeworkSpringCRUD.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
public class TimingAspect {

    @Around("execution(* ru.gb.homeworkSpringCRUD.service.*.*(..))")
    public Object timer(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis() - startTime;

        System.out.println("Method " + joinPoint.getSignature().getName() + "() took " + endTime + "ms");

        return result;
    }
}
