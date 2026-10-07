package com.pavani.focusquest.controller;
import com.pavani.focusquest.entity.Task;
import com.pavani.focusquest.entity.User;
import com.pavani.focusquest.repository.TaskRepository;
import com.pavani.focusquest.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/tasks")
public class TaskController {
    private final TaskRepository repo; private final UserService users;
    public TaskController(TaskRepository r,UserService u){repo=r;users=u;}
    @GetMapping("/user/{userId}") public List<Task> all(@PathVariable Long userId){return repo.findByUserIdOrderByCreatedAtDesc(userId);}
    @PostMapping public Task create(@RequestBody Map<String,Object> body){
        Task t=new Task(); t.setTitle((String)body.get("title")); t.setDescription((String)body.getOrDefault("description","")); t.setPriority((String)body.getOrDefault("priority","MEDIUM")); t.setUser(users.get(Long.valueOf(body.get("userId").toString()))); return repo.save(t);
    }
    @PutMapping("/{id}/complete") public Task complete(@PathVariable Long id){Task t=repo.findById(id).orElseThrow(); if(!t.isCompleted()){t.setCompleted(true);users.addXp(t.getUser().getId(),20);} return repo.save(t);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){repo.deleteById(id);}
}
