package ru.gb.homework_sem5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework_sem5.model.Task;
import ru.gb.homework_sem5.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public Task updateTaskStatusById(Long id, Task status) {
        Task optionalTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        optionalTask.setStatus(status.getStatus());
        return taskRepository.save(optionalTask);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
