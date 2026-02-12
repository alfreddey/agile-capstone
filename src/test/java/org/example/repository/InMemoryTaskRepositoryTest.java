package org.example.repository;

import org.example.model.Task;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskRepositoryTest {

  public static void main(String[] args) {
    testCreateAndGetTask();
    testDeleteTask();
    testGetAllTasks();

    System.out.println("All tests passed successfully!");
  }

  static void testCreateAndGetTask() {
    InMemoryTaskRepository repo = new InMemoryTaskRepository(new HashMap<>());
    Task task = new Task("1", "Test Task", "df", "C");

    repo.create(task);
    Task retrieved = repo.getById("1");

    assert retrieved != null : "Task should not be null";
    assert "1".equals(retrieved.id()) : "Task ID should match";
  }

  static void testDeleteTask() {
    InMemoryTaskRepository repo = new InMemoryTaskRepository(new HashMap<>());
    Task task = new Task("2", "To be deleted", "descr2", "C");

    repo.create(task);
    repo.delete("2");

    assert repo.getById("2") == null : "Task should be null after deletion";
  }

  static void testGetAllTasks() {
    InMemoryTaskRepository repo = new InMemoryTaskRepository(new HashMap<>());
    repo.create(new Task("1", "A", "des", "P"));
    repo.create(new Task("2", "B", "desc23", "P"));

    List<Task> all = repo.getAll();

    assert all.size() == 2 : "Repository should contain 2 tasks";
  }
}