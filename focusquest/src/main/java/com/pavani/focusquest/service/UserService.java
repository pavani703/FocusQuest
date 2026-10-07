package com.pavani.focusquest.service;
import com.pavani.focusquest.entity.User;
import com.pavani.focusquest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo; private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public UserService(UserRepository repo){this.repo=repo;}
    public User register(String name,String email,String password){
        if(repo.findByEmail(email).isPresent()) throw new IllegalArgumentException("Email already registered");
        User u=new User(); u.setName(name); u.setEmail(email); u.setPassword(encoder.encode(password)); return repo.save(u);
    }
    public User login(String email,String password){
        User u=repo.findByEmail(email).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
        if(!encoder.matches(password,u.getPassword())) throw new IllegalArgumentException("Invalid email or password");
        return u;
    }
    public User get(Long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));}
    public User addXp(Long id,int amount){ User u=get(id); int xp=u.getXp()+amount; u.setXp(xp); u.setLevel((xp/100)+1); return repo.save(u); }
}
