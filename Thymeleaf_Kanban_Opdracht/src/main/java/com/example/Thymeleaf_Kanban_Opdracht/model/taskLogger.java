package com.example.Thymeleaf_Kanban_Opdracht.model;

import java.time.LocalDateTime;

public interface taskLogger {
    LocalDateTime taskModifiedOn();
    String modifiedBy();

}
