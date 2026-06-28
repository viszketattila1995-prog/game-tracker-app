package com.attila.taskmanager.gametrackerapp.repository;

import com.attila.taskmanager.gametrackerapp.domain.Game;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface GameRepository extends JpaRepository<Game, Long> {
}
