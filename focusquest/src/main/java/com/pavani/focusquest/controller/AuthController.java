package com.pavani.focusquest.controller;
import com.pavani.focusquest.entity.User;
import com.pavani.focusquest.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController @RequestMapping("/api/auth")
public class AuthController {
    private final UserService service; public AuthController(UserService s){service=s;}
    @PostMapping("/register") public Map<String,Object> register(@RequestBody Map<String,String> body){
        User u=service.register(body.get("name"),body.get("email"),body.get("password")); return Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail());
    }
    @PostMapping("/login") public Map<String,Object> login(@RequestBody Map<String,String> body){
        User u=service.login(body.get("email"),body.get("password")); return Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail(),"xp",u.getXp(),"level",u.getLevel());
    }
    @GetMapping("/{id}") public User get(@PathVariable Long id){return service.get(id);}
}
