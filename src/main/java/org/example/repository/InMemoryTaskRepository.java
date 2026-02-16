package org.example.repository;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryTaskRepository implements TaskRepository {
  private final Map<String, Task> tasks;

  public InMemoryTaskRepository(Map<String, Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public Task create(Task task) {
    return tasks.put(Integer.toString(tasks.size() + 1), task);
  }

  @Override
  public void delete(String id) {
    tasks.remove(id);
  }

  @Override
  public Task getById(String id) {
    return tasks.get(id);
  }

  @Override
  public List<Task> getAll() {
    return new ArrayList<>(tasks.values());
  }
}
