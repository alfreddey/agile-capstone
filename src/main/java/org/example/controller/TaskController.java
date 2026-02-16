package org.example.controller;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.service.TaskService;
import org.example.service.TaskServiceImpl;
import org.example.ui.TaskUI;

import java.io.Console;
import java.util.Scanner;

public class TaskController {
  private final Scanner scanner = new Scanner(System.in);
  private final TaskUI taskUI;
  private final TaskService taskService;

  public TaskController(TaskUI taskUI, TaskService taskService) {
    this.taskUI = taskUI;
    this.taskService = taskService;
  }

  public void start() {



    try {
      do {
        taskUI.displayHomeMenu();
        System.out.print("\nEnter your choice: ");

        var opt = scanner.nextLine();

        switch (opt) {
          case "1":
            var task = createTask();
            taskService.add(task);
            break;
          case "2":
            var taskId = deleteTask();
            taskService.delete(taskId);
            break;
          case "3":
            displayTasks();
            break;
          default:
            throw new Exception("Invalid option");
        }

        clearScreen();
      } while (true);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void displayTasks() {
    taskService.getAll().forEach(System.out::println);
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