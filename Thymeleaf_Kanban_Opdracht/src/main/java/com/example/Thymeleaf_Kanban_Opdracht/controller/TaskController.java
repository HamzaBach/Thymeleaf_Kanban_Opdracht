package com.example.Thymeleaf_Kanban_Opdracht.controller;

import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
import com.example.Thymeleaf_Kanban_Opdracht.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getActiveTasks(Model model) {
        model.addAttribute("tasksToDoList", taskService.getToDoTasks());
        model.addAttribute("tasksInProgressList", taskService.getInProgressTasks());
        model.addAttribute("tasksOnHoldList", taskService.getOnHoldTasks());
        model.addAttribute("tasksCompletedList", taskService.getCompletedTasks());
        return "taskKanban";
    }

    @GetMapping("/newTask")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task",new Task());
        return "form_task";
    }

    @GetMapping("/editTask/{taskId}")
    public String showEditTaskForm(@PathVariable("taskId") Long taskId, Model model) {
        Task task = taskService.findById(taskId).get();
        model.addAttribute("task",task);
        return "form_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        this.taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/moveTaskForward/{taskId}")
    public String moveTaskForward(@PathVariable("taskId") Long taskId){
        this.taskService.moveTaskForward(taskId);
        return "redirect:/tasks";
    }
    @PostMapping("/moveTaskBackward/{taskId}")
    public String moveTaskBackward(@PathVariable("taskId") Long taskId){
        this.taskService.moveTaskBackward(taskId);
        return "redirect:/tasks";
    }

    @PostMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable("taskId") Long taskId){
        this.taskService.deleteTask(taskId);
        return "redirect:/tasks";
    }


}
