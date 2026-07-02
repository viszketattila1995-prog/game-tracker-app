package com.attila.taskmanager.gametrackerapp.service;

import com.attila.taskmanager.gametrackerapp.domain.Platform;
import com.attila.taskmanager.gametrackerapp.domain.Status;
import com.attila.taskmanager.gametrackerapp.dto.request.PlatformCreateCommand;
import com.attila.taskmanager.gametrackerapp.dto.response.PlatformDropdownResponse;
import com.attila.taskmanager.gametrackerapp.dto.response.PlatformSummary;
import com.attila.taskmanager.gametrackerapp.exception.PlatformWithNameAlreadyExists;
import com.attila.taskmanager.gametrackerapp.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;

    public Long createPlatform(PlatformCreateCommand command) {

        if (platformRepository.existsByName(command.getName().trim())) {
            throw new PlatformWithNameAlreadyExists("Platform already exists: " + command.getName());
        }

        Platform platform = new Platform();
        platform.setName(command.getName().trim());
        platform.setManufacturer(command.getManufacturer().trim());
        log.info("New platform created");
        return platformRepository.save(platform).getId();
    }

    @Transactional(readOnly = true)
    public List<PlatformDropdownResponse> getPlatforms() {

        List<Platform> platformList = platformRepository.findAll();
        log.info("Get platforms");

        return platformList.stream()
                .map(p -> new PlatformDropdownResponse(p.getId(), p.getName(), p.getManufacturer()))
                .toList();
    }

    public List<PlatformSummary> platformSummary() {

        List<Platform> platform = platformRepository.findAll();

        log.info("Summary page requested");

        return platform.stream()
                .map(p -> new PlatformSummary(
                        p.getId(),
                        p.getName(),
                        p.getManufacturer(),
                        p.getGames().size(),
                        p.getGames()
                                .stream().filter(c -> c.getStatus() == (Status.COMPLETED))
                                .count()

                )).toList();
    }
}
