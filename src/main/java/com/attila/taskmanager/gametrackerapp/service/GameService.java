package com.attila.taskmanager.gametrackerapp.service;

import com.attila.taskmanager.gametrackerapp.domain.Game;
import com.attila.taskmanager.gametrackerapp.domain.Platform;
import com.attila.taskmanager.gametrackerapp.domain.Status;
import com.attila.taskmanager.gametrackerapp.dto.request.GameCreateCommand;
import com.attila.taskmanager.gametrackerapp.dto.response.GameList;
import com.attila.taskmanager.gametrackerapp.exception.InvalidStatusException;
import com.attila.taskmanager.gametrackerapp.exception.PlatformWithIdNotExists;
import com.attila.taskmanager.gametrackerapp.repository.GameRepository;
import com.attila.taskmanager.gametrackerapp.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final PlatformRepository platformRepository;

    public Long createGame(GameCreateCommand command) {
        Platform platform = platformRepository.findById(command.getPlatformId())
                .orElseThrow(() -> new PlatformWithIdNotExists("Platform with this id doesn't exists: " + command.getPlatformId()));

        Status status;

        try {
            status = Status.valueOf(command.getStatus());
        } catch (IllegalArgumentException exception) {
            throw new InvalidStatusException("Invalid status: " + command.getStatus());
        }

        Game game = new Game();

        game.setTitle(command.getTitle().strip());
        game.setDeveloper(command.getDeveloper().strip());
        game.setReleaseYear(command.getReleaseYear());
        game.setStatus(status);
        game.setCoverUrl(command.getCoverUrl().strip());
        game.setPlatform(platform);
        game.setAddedAt(LocalDateTime.now());

        log.info("New game added");

        return gameRepository.save(game).getId();

    }

    @Transactional(readOnly = true)
    public List<Status> getStatus() {

        return Arrays.stream(Status.values()).toList();
    }

    @Transactional(readOnly = true)
    public List<GameList> getAllGames() {
        List<Game> games = gameRepository.findAllByOrderByAddedAtDesc();

        log.info("Games page requested");

        return games.stream()
                .map(game -> new GameList(
                        game.getId(),
                        game.getTitle(),
                        game.getDeveloper(),
                        game.getPlatform().getName(),
                        game.getStatus().name(),
                        game.getCoverUrl()))
                .toList();
    }
}
