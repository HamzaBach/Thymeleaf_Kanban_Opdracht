package com.example.Thymeleaf_Kanban_Opdracht.service;

import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
import com.example.Thymeleaf_Kanban_Opdracht.model.taskStatus;
import com.example.Thymeleaf_Kanban_Opdracht.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public List<Task> getActiveTasks(){
        return this.taskRepository.findByActiveTask(1);
    }
    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void moveTaskForward(Long id){
        Task task = taskRepository.findById(id).get();
        if(task.getStatus().equals(taskStatus.ToDo)){
            task.setStatus(taskStatus.Doing);
            taskRepository.save(task);
        } else if(task.getStatus().equals(taskStatus.Doing)){
            task.setStatus(taskStatus.Blocked);
            taskRepository.save(task);
        } else if (task.getStatus().equals(taskStatus.Blocked)){
            task.setStatus(taskStatus.Done);
            taskRepository.save(task);
        }
    }

    public void moveTaskBackward(Long id){
        Task task = taskRepository.findById(id).get();
        if(task.getStatus().equals(taskStatus.Doing)){
            task.setStatus(taskStatus.ToDo);
            taskRepository.save(task);
        } else if(task.getStatus().equals(taskStatus.Blocked)){
            task.setStatus(taskStatus.Doing);
            taskRepository.save(task);
        } else if (task.getStatus().equals(taskStatus.Done)){
            task.setStatus(taskStatus.Blocked);
            taskRepository.save(task);
        }
    }


}
