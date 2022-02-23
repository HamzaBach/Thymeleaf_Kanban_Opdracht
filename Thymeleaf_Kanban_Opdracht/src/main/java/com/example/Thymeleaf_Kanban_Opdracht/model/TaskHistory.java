package com.example.Thymeleaf_Kanban_Opdracht.model;

import java.time.LocalDateTime;

public class TaskHistory implements taskLogger{



    @Override
    public LocalDateTime taskModifiedOn() {
        return null;
    }

    @Override
    public String modifiedBy() {
        return null;
    }
}
