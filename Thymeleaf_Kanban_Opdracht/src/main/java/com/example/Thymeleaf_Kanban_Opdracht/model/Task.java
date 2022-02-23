package com.example.Thymeleaf_Kanban_Opdracht.model;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String name="New task";
    private String description="Add task description";
    private String assignedTo;
    private taskStatus status=taskStatus.ToDo;
    private int activeTask=1;

    public Task(String name, String description,String assignedTo,
                taskStatus status, int activeTask) {
        this.name = name;
        this.description = description;
        this.assignedTo=assignedTo;
        this.status = status;
        this.activeTask = activeTask;
    }
    public Task(){
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public taskStatus getStatus() {
        return status;
    }

    public void setStatus(taskStatus status) {
        this.status = status;
    }

    public int getActiveTask() {
        return activeTask;
    }

    public void setActiveTask(int activeTask) {
        this.activeTask = activeTask;
    }
}
