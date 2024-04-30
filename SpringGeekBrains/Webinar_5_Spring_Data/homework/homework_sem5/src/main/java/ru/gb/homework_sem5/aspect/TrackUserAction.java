package ru.gb.homework_sem5.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Аннотация TrackUserAction исползуется для маркировки методов вызываемых пользователем,
 * аннотация применятся к методам и собирает данные, которые могут быть использованы аспектом
 * для логирования событий.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TrackUserAction {
}
