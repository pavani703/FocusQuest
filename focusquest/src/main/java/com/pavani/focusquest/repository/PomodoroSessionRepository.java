package com.pavani.focusquest.repository;
import com.pavani.focusquest.entity.PomodoroSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PomodoroSessionRepository extends JpaRepository<PomodoroSession,Long>{ List<PomodoroSession> findByUserIdOrderByStartedAtDesc(Long userId); long countByUserIdAndSessionType(Long userId,String type); }
