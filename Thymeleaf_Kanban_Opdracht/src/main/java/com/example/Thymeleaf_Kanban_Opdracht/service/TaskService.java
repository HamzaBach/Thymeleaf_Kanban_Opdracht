package com.example.Thymeleaf_Kanban_Opdracht.service;

import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
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

    public List<Task> getToDoTasks(){
        return taskRepository.findByActiveTaskAndStatus(1,0);
    }
    public List<Task> getInProgressTasks(){
        return taskRepository.findByActiveTaskAndStatus(1,1);
    }
    public List<Task> getOnHoldTasks(){
        return taskRepository.findByActiveTaskAndStatus(1,2);
    }
    public List<Task> getCompletedTasks(){
        return taskRepository.findByActiveTaskAndStatus(1,3);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void moveTaskForward(Long id){
        Task task = taskRepository.findById(id).get();
        if(task.getStatus()==0){
            task.setStatus(1);
            taskRepository.save(task);
        } else if(task.getStatus()==1){
            task.setStatus(2);
            taskRepository.save(task);
        } else if (task.getStatus()==2){
            task.setStatus(3);
            taskRepository.save(task);
        }
    }

    public void moveTaskBackward(Long id){
        Task task = taskRepository.findById(id).get();
        if(task.getStatus()==1){
            task.setStatus(0);
            taskRepository.save(task);
        } else if(task.getStatus()==2){
            task.setStatus(1);
            taskRepository.save(task);
        } else if (task.getStatus()==3){
            task.setStatus(2);
            taskRepository.save(task);
        }
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).get();
        task.setActiveTask(0);
        taskRepository.save(task);
    }


}
