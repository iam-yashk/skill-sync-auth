package com.skillsync.task.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private String assignedTo;
    private String createdBy;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        READY,
        IN_PROGRESS,
        REVIEW,
        DONE,
        CLOSED
    }

}
