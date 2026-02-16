package org.example.controller;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.ui.TaskUI;

import java.util.Scanner;

public class TaskController {
  private final Scanner scanner = new Scanner(System.in);
  private final TaskUI taskUI;
  private final TaskRepository taskRepository;

  public TaskController(TaskUI taskUI, TaskRepository taskRepository) {
    this.taskUI = taskUI;
    this.taskRepository = taskRepository;
  }

  public void start() {

    taskUI.displayHomeMenu();
    System.out.print("\nEnter your choice: ");

    var opt = scanner.nextLine();

    switch (opt) {
      case "1":
        var task = createTask();
        taskRepository.create(task);
        break;
      case "2":
        var taskId = deleteTask();
        taskRepository.delete(taskId);
        break;
      case "3":
        displayTasks();
        break;
      default:
        throw new RuntimeException("Invalid option");
    }

  }

  private void displayTasks() {
    taskRepository.getAll().forEach(System.out::println);
  }

  private String deleteTask() {
    System.out.println("Enter task ID");
    var taskId = scanner.nextLine();

    return taskId;
  }

  private Task createTask() {
    System.out.println("Enter task name");
    var taskName = scanner.nextLine();

    System.out.println("Enter task description");
    var description = scanner.nextLine();

    System.out.println("Enter task status");
    var status = scanner.nextLine();

    return new Task("12", taskName, description, status);
  }
}
