package com.attila.taskmanager.gametrackerapp.controller;

import com.attila.taskmanager.gametrackerapp.domain.Status;
import com.attila.taskmanager.gametrackerapp.dto.request.GameCreateCommand;
import com.attila.taskmanager.gametrackerapp.dto.response.GameList;
import com.attila.taskmanager.gametrackerapp.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<Void> createGame(@Valid @RequestBody GameCreateCommand command) {
        Long gameId = gameService.createGame(command);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(gameId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Status>> getStatus() {
        List<Status> statusData = gameService.getStatus();

        return ResponseEntity.ok(statusData);
    }

    @GetMapping
    public ResponseEntity<List<GameList>> getGameList() {
        List<GameList> gameList = gameService.getAllGames();

        return ResponseEntity.ok(gameList);
    }
}
