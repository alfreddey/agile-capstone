package org.example;

import org.example.controller.TaskController;
import org.example.model.Task;
import org.example.repository.InMemoryTaskRepository;
import org.example.ui.TaskUI;

import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    var map = new HashMap<String, Task>();
    map.put("1", new Task("1", "dsfasd", "dfafe", "C"));
    map.put("2", new Task("2", "dsfasd", "dfafe", "C"));
    map.put("3", new Task("3", "dsfasd", "dfafe", "C"));
    map.put("12", new Task("12", "dsfasd", "dfafe", "C"));

    var taskController = new TaskController(new TaskUI(), new InMemoryTaskRepository(map));

    taskController.start();
  }
}