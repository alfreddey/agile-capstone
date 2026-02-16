package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceImplTest {

  public static void main(String[] args) {
    testAddAndGetById();
    testDelete();
    testGetAll();

    System.out.println("Service tests passed successfully!");
  }

  static void testAddAndGetById() {
    MockTaskRepository repo = new MockTaskRepository();
    TaskService service = new TaskServiceImpl(repo);
    Task task = new Task("1", "Service Task", "desc", "P");

    service.add(task);
    Task retrieved = service.getById("1");

    assert retrieved != null : "Task should be retrieved via service";
    assert "1".equals(retrieved.id()) : "IDs should match";
  }

  static void testDelete() {
    MockTaskRepository repo = new MockTaskRepository();
    TaskService service = new TaskServiceImpl(repo);
    service.add(new Task("2", "Delete Me", "desc", "C"));

    service.delete("2");
    assert service.getById("2") == null : "Task should be removed from repository";
  }

  static void testGetAll() {
    MockTaskRepository repo = new MockTaskRepository();
    TaskService service = new TaskServiceImpl(repo);
    service.add(new Task("1", "T1", "d", "P"));
    service.add(new Task("2", "T2", "d", "P"));

    List<Task> all = service.getAll();
    assert all.size() == 2 : "Should return all tasks from repository";
  }

  /**
   * Simple Manual Mock for TaskRepository
   */
  static class MockTaskRepository implements TaskRepository {
    private final List<Task> storage = new ArrayList<>();

    @Override
    public Task create(Task task) {
      storage.add(task);
      return task;
    }

    @Override
    public void delete(String id) {
      storage.removeIf(t -> t.id().equals(id));
    }

    @Override
    public Task getById(String id) {
      return storage.stream().filter(t -> t.id().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Task> getAll() {
      return new ArrayList<>(storage);
    }
  }
}