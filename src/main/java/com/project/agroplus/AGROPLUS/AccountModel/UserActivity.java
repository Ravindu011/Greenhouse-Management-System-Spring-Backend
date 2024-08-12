package com.project.agroplus.AGROPLUS.AccountModel;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private LocalDate date;
    private LocalTime time;
    private String editedUsername;

    // Default constructor
    public UserActivity() {
        // Initialize default values if necessary
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getEditedUsername() {
        return editedUsername;
    }

    public void setEditedUsername(String editedUsername) {
        this.editedUsername = editedUsername;
    }

    // Automatically set the current date and time before persisting
    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDate.now();
        }
        if (this.time == null) {
            this.time = LocalTime.now();
        }
    }
}
