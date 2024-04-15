package ru.gb.homework_sem5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework_sem5.model.Task;
import ru.gb.homework_sem5.service.TaskService;

import java.util.List;

/**
 * Этот класс является контроллером для обработки задач.
 * Он является атрибутом @RestController, что означает, что он возвращает JSON-данные.
 * Контроллер определен с помощью @RequestMapping и сопоставлен с "/tasks" конечной точкой.
 *
 * @see TaskService
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    /**
     * Это поле - это инстанс TaskService, который используется для взаимодействия с данными о задачах.
     * Он внедряется с помощью конструктора @RequiredArgsConstructor
     */
    private final TaskService taskService;


    /**
     * Этот метод добавляет новую задачу в сервис.
     * Он принимает задачу в виде объекта Task в качестве запроса тела и возвращает только что было добавлено.
     * @param task задача, которую нужно добавить
     * @return задача, которая была добавлена
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * Этот метод получает все задачи из сервиса.
     * Он просто возвращает список всех задач, полученных из taskService.
     * @return список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Этот метод получает задачи из сервиса по их статусу.
     * Он принимает статус задач в качестве параметра пути и возвращает список задач с указанным статусом.
     * @param status статус задач, по которым нужно получить задачи
     * @return список задач с указанным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    /**
     * Этот метод обновляет статус задачи в сервисе.
     * Он принимает ID задачи в качестве параметра пути и задачу с обновленным статусом в качестве тела запроса.
     * Он обновляет статус задачи с указанным ID.
     * @param id ID задачи, которая нуждается в обновлении статуса
     * @param task задача с обновленным статусом
     * @return задача с обновленным статусом
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTaskStatusById(id, task);
    }

    /**
     * Этот метод удаляет задачу из сервиса.
     * Он принимает ID задачи в качестве параметра пути и удаляет задачу с указанным ID из сервиса.
     * @param id ID задачи, которая нуждается в удалении
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
