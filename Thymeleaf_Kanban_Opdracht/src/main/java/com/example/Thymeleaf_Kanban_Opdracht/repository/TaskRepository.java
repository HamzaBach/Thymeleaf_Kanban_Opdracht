package com.example.Thymeleaf_Kanban_Opdracht.repository;

import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByActiveTask(int activeTask);
}
