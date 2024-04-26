package ru.gb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

//    https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html
    @Around("execution(* ru.gb.service.CommentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        System.out.println("Начало метода " + joinPoint.getSignature().getName());

        Object returnedByMethod = joinPoint.proceed();

        System.out.println("Конец метода " + joinPoint.getSignature().getName());


        return "Другая запись!"; // returnedByMethod;
    }


}
