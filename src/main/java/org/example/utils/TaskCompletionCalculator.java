package org.example.utils;

import org.example.model.Task;

import java.util.List;

public class TaskCompletionCalculator {
  public static int calculateCompletedTasks(List<Task> tasks) {
    return (int) tasks.stream().filter(task -> task.status().equalsIgnoreCase("C")).count();
  }
}
