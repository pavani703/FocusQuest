package com.pavani.focusquest.controller;
import com.pavani.focusquest.entity.PomodoroSession;
import com.pavani.focusquest.repository.PomodoroSessionRepository;
import com.pavani.focusquest.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController @RequestMapping("/api/sessions")
public class SessionController {
    private final PomodoroSessionRepository repo; private final UserService users;
    public SessionController(PomodoroSessionRepository r,UserService u){repo=r;users=u;}
    @GetMapping("/user/{userId}") public List<PomodoroSession> all(@PathVariable Long userId){return repo.findByUserIdOrderByStartedAtDesc(userId);}
    @PostMapping public PomodoroSession create(@RequestBody Map<String,Object> body){
        PomodoroSession s=new PomodoroSession(); s.setSessionType((String)body.getOrDefault("sessionType","FOCUS")); s.setDurationMinutes(Integer.parseInt(body.getOrDefault("durationMinutes",25).toString())); s.setStartedAt(LocalDateTime.now()); s.setEndedAt(LocalDateTime.now()); s.setUser(users.get(Long.valueOf(body.get("userId").toString()))); users.addXp(s.getUser().getId(),10); return repo.save(s);
    }
    @GetMapping("/stats/{userId}") public Map<String,Object> stats(@PathVariable Long userId){
        List<PomodoroSession> list=repo.findByUserIdOrderByStartedAtDesc(userId); long focus=list.stream().filter(s->"FOCUS".equals(s.getSessionType())).count(); int mins=list.stream().filter(s->"FOCUS".equals(s.getSessionType())).mapToInt(PomodoroSession::getDurationMinutes).sum(); return Map.of("sessions",focus,"focusMinutes",mins);
    }
}
