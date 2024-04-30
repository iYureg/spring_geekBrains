package ru.gb.homework_sem5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;


/**
 * Класс для отслеживания действий пользователя и вывод результатов в консоль
 */
@Aspect
@Component
public class UserActionTrackingAspect {

    /**
     * Список действий
     */
    Map<String, String> actions = Map.of(
            "getAllTasks", "Запрос всех задач",
            "saveTask", "Сохранение задачи",
            "addTask", "Добавление задачи",
            "deleteTask", "Удаление задачи",
            "getTaskByStatus", "Получеине задач по статусу"
    );


    @Around("@annotation(TrackUserAction)")
    public Object trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = actions.get(joinPoint.getSignature().getName());
        String arguments = Arrays.toString(args);
        println("Время начала: " + LocalDateTime.now(), Colors.YELLOW);
        print(methodName + ", аргументы: " + arguments, Colors.BLUE);


        long runtime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        runtime = System.currentTimeMillis() - runtime;

        printf(", выполнено за: %d мс\n", runtime, Colors.GREEN);
        println("Время окончания: " + LocalDateTime.now(), Colors.YELLOW);
        println("=====================================================================================================================================", Colors.MAGENTA);
        return result;
    }

    public static void println(String msg, Colors displayColor) {
        System.out.println(displayColor + msg + Colors.RESET);
    }

    public static void print(String msg, Colors displayColor) {
        System.out.print(displayColor + msg + Colors.RESET);
    }

    public static void printf(String msg, Object object, Colors displayColor) {
        System.out.printf(displayColor + msg, object, Colors.RESET);
    }
}
