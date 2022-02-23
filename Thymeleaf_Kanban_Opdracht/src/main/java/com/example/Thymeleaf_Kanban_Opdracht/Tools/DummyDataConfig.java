//package com.example.Thymeleaf_Kanban_Opdracht.Tools;
//
//import com.example.Thymeleaf_Kanban_Opdracht.model.Task;
//import com.example.Thymeleaf_Kanban_Opdracht.model.taskStatus;
//import com.example.Thymeleaf_Kanban_Opdracht.repository.TaskRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DummyDataConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
//        return args -> {
//            Task task1 = new Task("Aanmaak thymeleaf template",
//                    "Het HTML gedeelte van de kanbanopdracht dient " +
//                            "via Thymeleaf aangemaakt te worden.", "Hamza",
//                    taskStatus.ToDo, 1);
//            Task task2 = new Task("Controller aanmaken",
//                    "De controller dient aangemaakt te worden teneinde verschillende" +
//                            "endpoints te hosten voor het inladen en wegschrijven van taken" +
//                            "van en naar de database", "Hamza",
//                    taskStatus.ToDo, 1);
//            Task task3 = new Task("Service layer aanmaken",
//                    "De service layer dient aangemaakt te worden teneinde hierin" +
//                            "de business logic in te kunnen verwerken", "Hamza",
//                    taskStatus.ToDo, 1);
//            Task task4 = new Task("Data access layer aanmaken",
//                    "De data access layer dient aangemaakt te worden teneinde de taken" +
//                            "te kunnen inladen en wegschrijven naar een SQL database", "Hamza",
//                    taskStatus.ToDo, 1);
//
//            taskRepository.save(task1);
//            taskRepository.save(task2);
//            taskRepository.save(task3);
//            taskRepository.save(task4);
//
//        };
//    }
//}
