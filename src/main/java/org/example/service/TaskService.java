package org.example.service;

import org.example.model.Task;

import java.util.List;

public interface TaskService {
  Task add(Task task);
  void delete(String id);
  Task getById(String id);
  List<Task> getAll();
}
