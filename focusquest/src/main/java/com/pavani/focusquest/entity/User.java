package com.pavani.focusquest.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String password;
    private int xp = 0;
    private int level = 1;

    public User() {}
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPassword(){return password;} public void setPassword(String v){password=v;}
    public int getXp(){return xp;} public void setXp(int v){xp=v;}
    public int getLevel(){return level;} public void setLevel(int v){level=v;}
}
