package com.attila.taskmanager.gametrackerapp.repository;

import com.attila.taskmanager.gametrackerapp.domain.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    boolean existsByName(String name);
}
