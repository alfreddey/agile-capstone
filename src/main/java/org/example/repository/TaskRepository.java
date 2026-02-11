package org.example.repository;

import org.example.model.Task;

import java.util.List;

public interface TaskRepository {
  Task create(Task task);
  void delete(String id);
  Task getById(String id);
  List<Task> getAll();
}
