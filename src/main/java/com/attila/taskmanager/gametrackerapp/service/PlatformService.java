package com.attila.taskmanager.gametrackerapp.service;

import com.attila.taskmanager.gametrackerapp.domain.Platform;
import com.attila.taskmanager.gametrackerapp.dto.request.PlatformCreateCommand;
import com.attila.taskmanager.gametrackerapp.exception.PlatformWithNameAlreadyExists;
import com.attila.taskmanager.gametrackerapp.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;

    public Long createPlatform(PlatformCreateCommand command) {

        if (platformRepository.existsByName(command.getName())) {
            throw new PlatformWithNameAlreadyExists("Platform already exists: " + command.getName());
        }

        Platform platform = new Platform();
        platform.setName(command.getName());
        platform.setManufacturer(command.getManufacturer());
        log.info("New platform created");
        return platformRepository.save(platform).getId();
    }
}
