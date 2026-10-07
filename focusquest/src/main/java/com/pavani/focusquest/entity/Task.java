package com.pavani.focusquest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
public class Task {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false) private String title;
    private String description;
    private String priority = "MEDIUM";
    private boolean completed = false;
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;

    public Task() {}
    public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public String getPriority(){return priority;} public void setPriority(String v){priority=v;}
    public boolean isCompleted(){return completed;} public void setCompleted(boolean v){completed=v;}
    public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
    public User getUser(){return user;} public void setUser(User v){user=v;}
}
