package com.attila.taskmanager.gametrackerapp.repository;

import com.attila.taskmanager.gametrackerapp.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByOrderByAddedAtDesc();
}
