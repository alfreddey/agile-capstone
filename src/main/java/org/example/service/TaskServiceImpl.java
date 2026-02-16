package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;

import java.util.List;

public class TaskServiceImpl implements TaskService {
  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public Task add(Task task) {
    return taskRepository.create(task);
  }

  @Override
  public void delete(String id) {
    taskRepository.delete(id);
  }

  @Override
  public Task getById(String id) {
    return taskRepository.getById(id);
  }

  @Override
  public List<Task> getAll() {
    return taskRepository.getAll();
  }
}
