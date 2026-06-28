package com.attila.taskmanager.gametrackerapp.controller;

import com.attila.taskmanager.gametrackerapp.dto.request.GameCreateCommand;
import com.attila.taskmanager.gametrackerapp.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
}
