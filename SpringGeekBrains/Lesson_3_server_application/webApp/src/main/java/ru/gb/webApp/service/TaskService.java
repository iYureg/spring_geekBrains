package ru.gb.webApp.service;

import org.springframework.stereotype.Service;
import ru.gb.webApp.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTask(UUID uuid) {
        return tasks.stream()
                .filter(task -> task.getId().equals(uuid))
                .findFirst()
                .orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID uuid) {
        tasks.removeIf(task -> task.getId().equals(uuid));
    }

    public Task updateTask(UUID uuid, Task task) {
        Task taskToUpdate = getTask(uuid);
        if (taskToUpdate != null) {
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setName(task.getName());
            taskToUpdate.setStatus(task.getStatus());
            taskToUpdate.setCompletionTime(task.getCompletionTime());
        }
        return taskToUpdate;
    }
}
