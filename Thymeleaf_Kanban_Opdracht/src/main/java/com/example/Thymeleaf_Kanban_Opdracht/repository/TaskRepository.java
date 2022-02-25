package com.example.Thymeleaf_Kanban_Opdracht.repository;

import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByActiveTask(int activeTask);
//    @Query(value = "select e from thymeleaf_kanban where e.status=:0 AND e.active_task=:1", nativeQuery = true)
//    List<Task> getToDoTasks();
    List<Task> findByActiveTaskAndStatus(int activeTask,int status);

}
