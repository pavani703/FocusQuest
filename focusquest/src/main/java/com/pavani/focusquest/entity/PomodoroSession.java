package com.pavani.focusquest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="pomodoro_sessions")
public class PomodoroSession {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String sessionType;
    private int durationMinutes;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
    @ManyToOne @JoinColumn(name="task_id") private Task task;

    public PomodoroSession() {}
    public Long getId(){return id;} public String getSessionType(){return sessionType;} public void setSessionType(String v){sessionType=v;}
    public int getDurationMinutes(){return durationMinutes;} public void setDurationMinutes(int v){durationMinutes=v;}
    public LocalDateTime getStartedAt(){return startedAt;} public void setStartedAt(LocalDateTime v){startedAt=v;}
    public LocalDateTime getEndedAt(){return endedAt;} public void setEndedAt(LocalDateTime v){endedAt=v;}
    public User getUser(){return user;} public void setUser(User v){user=v;}
    public Task getTask(){return task;} public void setTask(Task v){task=v;}
}
