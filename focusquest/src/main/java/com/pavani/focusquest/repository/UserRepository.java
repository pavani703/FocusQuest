package com.pavani.focusquest.repository;
import com.pavani.focusquest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long>{ Optional<User> findByEmail(String email); }
