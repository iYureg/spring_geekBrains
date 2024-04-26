package ru.gb.homeworkSpringCRUD.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
public class LoggingAspect {

    @AfterReturning(value = "@annotation(ToLog)", returning = "result")
    public void log(Object result) {
        System.out.print("Executed and returned  " + result + "\n");
    }
}
